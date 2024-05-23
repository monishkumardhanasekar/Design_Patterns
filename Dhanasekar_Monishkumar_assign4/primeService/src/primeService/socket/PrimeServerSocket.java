package primeService.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import primeService.server.AllPrimeQueries;
import primeService.server.ServerMenu;
import primeService.util.Debug;

public class PrimeServerSocket {
    private int port;
    private AllPrimeQueries allQueries;
    private final List<PrimeServerWorker> workers;
    private Debug debug;

    public PrimeServerSocket(int port, AllPrimeQueries allQueries) throws IOException {
        this.workers = new ArrayList<>();
        this.port = port;
        this.allQueries = allQueries;
        this.debug = Debug.getInstance();
    }

    public void startServer() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            debug.printDebug("Server started on port " + port);
            ServerMenu serverMenu = new ServerMenu(allQueries,this);
            Thread menuThread = new Thread(() -> {
                try {
                    serverMenu.runMenu();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            menuThread.start();

            while (true) {
                Socket socket = serverSocket.accept();
                PrimeServerWorker worker = new PrimeServerWorker(socket, allQueries);
                workers.add(worker);
                worker.start();
            }
        } catch (IOException e) {
            debug.printDebug("Error in PrimeServerSocket: " + e.getMessage());
            e.printStackTrace();
            notifyClientsToExit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void notifyClientsToExit() {
        try{
            for (PrimeServerWorker worker : workers) {
                System.out.println("Quiting the client from server");
                worker.sendQuitSignal();
                worker.notifyToExit();
                debug.writer.close();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
