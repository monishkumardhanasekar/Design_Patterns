package primeService.server;

import java.io.IOException;
import java.util.Scanner;

import primeService.socket.PrimeServerSocket;
import primeService.util.Debug;

public class ServerMenu {
    private AllPrimeQueries allQueries;
    private PrimeServerSocket primeServerSocket;

    public ServerMenu(AllPrimeQueries allQueries,PrimeServerSocket primeServerSocketIn) {
        this.allQueries = allQueries;
        this.primeServerSocket = primeServerSocketIn;
    }

    public void runMenu() throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            Debug.getInstance().printDebug("Showing Server Menu");
            while (true) {
                System.out.println("Server Menu:");
                System.out.println("[1] Client Name [print the name]");
                System.out.println("[2] All Client Queries [print all names and queries so far]");
                System.out.println("[3] Quit [quit the server]");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Client Name and Query Integer:");
                        System.out.println(allQueries.getClientNames());
                        break;

                    case 2:
                        System.out.println("All Client Queries:");
                        System.out.println(allQueries.getAllQueries());
                        break;

                    case 3:
                        System.out.println("Quitting server...");
                        primeServerSocket.notifyClientsToExit();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
