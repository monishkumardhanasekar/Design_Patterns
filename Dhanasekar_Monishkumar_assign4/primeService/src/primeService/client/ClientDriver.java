package primeService.client;
import primeService.socket.PrimeClientSocket;
import primeService.util.Debug;

public class ClientDriver {
    public static void clientDriverMain(String[] args) {
        try{
            Debug debug = Debug.getInstance();
            String hostName = args[1];
            int port = Integer.parseInt(args[0]);
            debug.printDebug("Opening socket for client in port: "+ port);
            PrimeClientSocket clientSocket = new PrimeClientSocket(hostName, port);
            ClientMenu clientMenu = new ClientMenu(clientSocket);
            clientMenu.runMenu();
        }
        catch(Exception ex){
            System.out.println("Client Stopped");
            ex.printStackTrace();
        }
    }
}