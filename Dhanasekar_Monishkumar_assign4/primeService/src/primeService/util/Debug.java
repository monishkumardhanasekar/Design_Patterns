package primeService.util;

import java.io.FileWriter;
import java.io.IOException;

public class Debug 
{
    private static Debug instance;
    public FileWriter writer;

    private Debug() throws IOException {
        FileWriter fileWriter = new FileWriter("log.txt");
        fileWriter.close();
        writer = new FileWriter("log.txt",true);
    }

    
    public static Debug getInstance() throws IOException {
        if (instance == null) {
            instance = new Debug();
        }
        return instance;
    }


    public void printDebug(String message) throws IOException {
        // System.out.println("[DEBUG] " + message);
        writer.write("[DEBUG] " + message +"\n");
    }
}



    

