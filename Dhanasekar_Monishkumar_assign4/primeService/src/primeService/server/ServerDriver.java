package primeService.server;

import primeService.socket.PrimeServerSocket;
import primeService.util.Debug;

public class ServerDriver {
    public static void serverDriverMain(String[] args) {
        try{
            Debug debug = Debug.getInstance();
            if (args.length != 1) {
                System.out.println("Usage: java ServerDriver <port>");
                System.exit(1);
            }            
            int port = Integer.parseInt(args[0]);
            debug.printDebug("Server opened a socket for port:"+ port);
            AllPrimeQueries allQueries = new AllPrimeQueries();
            PrimeServerSocket serverSocket = new PrimeServerSocket(port, allQueries);
            serverSocket.startServer();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
