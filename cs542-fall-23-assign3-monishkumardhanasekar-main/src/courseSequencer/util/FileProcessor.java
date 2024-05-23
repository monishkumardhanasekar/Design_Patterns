package courseSequencer.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {
     public void readFile(InputReaderInterface inputRead,String InputFile){
        try (BufferedReader reader = new BufferedReader(new FileReader(InputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                inputRead.workLine(line);
            }
            reader.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedWriter getWriter(String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName,false);
        return new BufferedWriter(fileWriter);
    }
}
