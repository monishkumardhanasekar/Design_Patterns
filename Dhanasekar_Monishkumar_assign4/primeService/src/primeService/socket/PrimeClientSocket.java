package primeService.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class PrimeClientSocket {
    public Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    public PrimeClientSocket(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public void sendQuery(String query) throws IOException {
        try{
        writer.write(query);
        writer.newLine();
        writer.flush();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public String receiveResponse() throws IOException {
        return reader.readLine();
    }

    public boolean isQuitSignalReceived() throws IOException {
        try{
            String message = reader.readLine();
            return message.equals("<quit>"); // Check if the received message is a quit signal
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public void close() throws IOException {
        socket.close();
    }
}
