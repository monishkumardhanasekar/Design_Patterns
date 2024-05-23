package primeService.driver;
import primeService.client.ClientDriver;
import primeService.server.ServerDriver;
import primeService.util.Debug;

public class PrimeDriver {
    public static void main(String[] args) {
        try{
            Debug debug = Debug.getInstance();
            if (args.length < 2) {
                System.out.println("Command line should have atleast have two arguments for mode and port");
                System.exit(1);
            }

            String mode = args[0];

            if (mode.equals("server")) {
                if (args.length != 3 ) {
                    System.out.println(args[2]);
                    System.out.println("To invoke server, arguments format should be like: <mode> <port>");
                    System.exit(1);
                }

                debug.printDebug("Starting server...");
                ServerDriver.serverDriverMain(new String[]{args[1]});
            } 
            else if (mode.equals("client")) {
                if (args.length != 3) {
                    System.out.println("To invoke client, arguments format should be like: <mode> <port> <hostname>");
                    System.exit(1);
                }
                debug.printDebug("Starting client...");
                ClientDriver.clientDriverMain(new String[]{args[1], args[2]});
            } 
            else {
                System.out.println("Invalid mode. Use 'server' or 'client'.");
                System.exit(1);
            }
            
            debug.writer.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
