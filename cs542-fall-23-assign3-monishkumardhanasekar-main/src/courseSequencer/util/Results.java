package courseSequencer.util;

import java.io.BufferedWriter;

public class Results {
    public static void writeOutput(FileProcessor processor, String outputFile, DataStructures dataObj){
        try{
            BufferedWriter writer = processor.getWriter(outputFile);
            String output = dataObj.output.toString();
            writer.write(output); 
            writer.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}