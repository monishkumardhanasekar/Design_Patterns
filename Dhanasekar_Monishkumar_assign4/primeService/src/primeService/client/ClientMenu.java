package primeService.client;

import primeService.socket.PrimeClientSocket;
import primeService.util.Debug;

import java.io.IOException;
import java.util.Scanner;

public class ClientMenu {
    private PrimeClientSocket clientSocket;

    public ClientMenu(PrimeClientSocket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void runMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);

        try {
            String clientName = "";
            Debug debug = Debug.getInstance();
            debug.printDebug("Showing Client Menu");
            while (true) {
                System.out.println("Menu:");
                System.out.println("[1] Set client name");
                System.out.println("[2] Enter number to query for prime");
                System.out.println("[3] What is the server response?");
                System.out.println("[4] Quit");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline character

                switch (choice) {
                    case 1:
                        System.out.println("Enter client name:");
                        clientName = scanner.nextLine();
                        break;
                    case 2:
                        System.out.println("Enter number to query for prime:");
                        int queryValue = scanner.nextInt();
                        scanner.nextLine(); // consume the newline character
                        String query = String.format("<primeQuery><clientName>%s</clientName><isPrime>%d</isPrime></primeQuery>", clientName, queryValue);
                        clientSocket.sendQuery(query);
                        break;
                    case 3:
                        String serverResponse = clientSocket.receiveResponse();
                        if(serverResponse.equals("<quit>")){
                            debug.printDebug("Quitting Client");
                            clientSocket.close();
                            System.out.println("Server already closed. client is quiting...");
                            debug.writer.close();
                            System.exit(0);
                        }
                        System.out.println("Server Response: " + serverResponse);
                        break;
                    case 4:
                        System.out.println("Quitting client.");
                        debug.printDebug("Quiting Client");
                        debug.writer.close();
                        clientSocket.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
                
            }
        } catch (IOException e) {
            clientSocket.close();
            System.exit(0);
            e.printStackTrace();
        }
        scanner.close();
    }
}
