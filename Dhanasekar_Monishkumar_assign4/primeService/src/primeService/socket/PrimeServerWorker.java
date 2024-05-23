package primeService.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import primeService.server.AllPrimeQueries;
import primeService.util.CheckPrime;
import primeService.util.Debug;

public class PrimeServerWorker extends Thread{
    private Socket socket;
    private AllPrimeQueries allQueries;
    private Debug debug;
    private BufferedReader reader;
    private PrintWriter writer;

    public PrimeServerWorker(Socket socket, AllPrimeQueries allQueries) {
        try{
        this.socket = socket;
        this.allQueries = allQueries;
        this.debug = Debug.getInstance();
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream(), true);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            

            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                debug.printDebug("Received: " + inputLine);
                if (inputLine.startsWith("<primeQuery>")) {
                    String clientName = inputLine.split("<clientName>")[1].split("</clientName>")[0];
                    int value = Integer.parseInt(inputLine.split("<isPrime>")[1].split("</isPrime>")[0]);

                    allQueries.addQuery(clientName, value);

                    String response = "<primeQueryResponse><intValue>" + value + "</intValue><isPrime>"
                            + CheckPrime.checkPrime(value) + "</isPrime></primeQueryResponse>";
                    writer.println(response);
                }
            }

            // socket.close();
        } catch (IOException e) {
            notifyToExit();
        }
    }
    public void notifyToExit() {
        try {
            socket.close();
            debug.writer.close();
        } catch (IOException ignored) {
        }
    }
    public void sendQuitSignal() {
        writer.println("<quit>"); // Send a quit signal to the client
    }
}
