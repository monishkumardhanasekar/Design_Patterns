package studentCoursesMgmt.util;

import java.io.BufferedReader;
import java.io.IOException;

public class BSTBuilder {
    private BinarySearchTree mainBST;
    private BinarySearchTree backup1BST;
    private BinarySearchTree backup2BST;
    private BinarySearchTree backup3BST;

    public BSTBuilder(BinarySearchTree main, BinarySearchTree backup1, BinarySearchTree backup2, BinarySearchTree backup3) {
        this.mainBST = main;
        this.backup1BST = backup1;
        this.backup2BST = backup2;
        this.backup3BST = backup3;
    }

    public void buildTrees(String fileName) {
        FileProcessor fileProcessor  = new FileProcessor();
        try (BufferedReader reader = fileProcessor.getFileReader(fileName)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                int bNumber = Integer.parseInt(parts[0].trim());
                String firstName = parts[1].trim();

                Node backup1 = new Node(bNumber, firstName);
                Node backup2 = new Node(bNumber, firstName);
                Node backup3 = new Node(bNumber, firstName);

                // Insert main node and simultaneously register backup nodes to it
                mainBST.insert(bNumber, firstName, backup1, backup2, backup3);

                // Insert the backup nodes in their respective backup BSTs
                backup1BST.insert(backup1);
                backup2BST.insert(backup2);
                backup3BST.insert(backup3);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

