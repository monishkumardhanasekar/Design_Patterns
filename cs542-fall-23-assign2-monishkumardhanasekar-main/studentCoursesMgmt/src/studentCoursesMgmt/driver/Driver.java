package studentCoursesMgmt.driver;

import studentCoursesMgmt.util.BSTBuilder;
import studentCoursesMgmt.util.BinarySearchTree;
import studentCoursesMgmt.util.FileProcessor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver {
    public static void main(String[] args) throws IOException {
        // Read command line arguments
        // ...
        if (args.length != 5) {

            System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
            System.exit(0);

        }
        System.out.println("0: " +args[0]);
        System.out.println("1: "+args[1]);
        System.out.println("2: "+args[2]);
        System.out.println("3: "+args[3]);
        System.out.println("4: "+args[4]);

        // Set debug level in MyLogger class
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.setLevel(Level.INFO);

        // Use BSTBuilder to build the trees
        BinarySearchTree mainBST = new BinarySearchTree();
        BinarySearchTree backup1BST = new BinarySearchTree();
        BinarySearchTree backup2BST = new BinarySearchTree();
        BinarySearchTree backup3BST = new BinarySearchTree();

        // Use FileProcessor to read the input and populate the trees
        BSTBuilder bstBuilder = new BSTBuilder(mainBST, backup1BST, backup2BST, backup3BST);
        bstBuilder.buildTrees(args[0]);

        FileProcessor fileProcessor = new FileProcessor();
        FileWriter fileWriter  = fileProcessor.getFileWriter(args[1]);
        FileWriter errorFileWriter = fileProcessor.getFileWriter(args[2]);

        fileWriter.write("BST: ");
        mainBST.inOrderTraversal(fileWriter);
        fileWriter.write(System.lineSeparator());

        fileWriter.write("Backup-1: ");
        backup1BST.inOrderTraversal(fileWriter);
        fileWriter.write(System.lineSeparator());

        fileWriter.write("Backup-2: ");
        backup2BST.inOrderTraversal(fileWriter);
        fileWriter.write(System.lineSeparator());

        fileWriter.write("Backup-3: ");
        backup3BST.inOrderTraversal(fileWriter);
        fileWriter.write(System.lineSeparator());
        fileWriter.write(System.lineSeparator());


        try {
            fileWriter.write("Sum of BNumbers in Main BST: " + mainBST.sumBNumbers());
            fileWriter.write(System.lineSeparator());
            fileWriter.write("Sum of BNumbers in Backup-1 BST: " + backup1BST.sumBNumbers());
            fileWriter.write(System.lineSeparator());
            fileWriter.write("Sum of BNumbers in Backup-2 BST: " + backup2BST.sumBNumbers());
            fileWriter.write(System.lineSeparator());

            fileWriter.write("Sum of BNumbers in Backup-3 BST: " + backup3BST.sumBNumbers());
            fileWriter.write(System.lineSeparator());

        } catch (IOException e) {
            errorFileWriter.write(e.toString());
            e.printStackTrace();
        }

        fileWriter.write("\nAfter Incrementing BNumbers:\n");
        fileWriter.write(System.lineSeparator());

        int UPDATE_VALUE = Integer.parseInt(args[4]);  // or any other value
        mainBST.incrementBNumbers(UPDATE_VALUE);


        fileWriter.write("Sum of BNumbers in Main BST: " + mainBST.sumBNumbers());
        fileWriter.write(System.lineSeparator());

        fileWriter.write("Sum of BNumbers in Backup-1 BST: " + backup1BST.sumBNumbers());
        fileWriter.write(System.lineSeparator());

        fileWriter.write("Sum of BNumbers in Backup-2 BST: " + backup2BST.sumBNumbers());
        fileWriter.write(System.lineSeparator());

        fileWriter.write("Sum of BNumbers in Backup-3 BST: " + backup3BST.sumBNumbers());
        fileWriter.write(System.lineSeparator());


        fileWriter.close();
    }
}
