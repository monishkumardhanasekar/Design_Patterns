package studentCoursesMgmt.util;

import java.io.FileWriter;
import java.io.IOException;

public class BinarySearchTree {

    private Node root; // Root node of the BST

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(Node node) {
        root = insertRec(root, node);
    }

    // Recursive method to insert a node into the BST
    private Node insertRec(Node currentRoot, Node node) {
        if (currentRoot == null) {
            return node;
        }

        if (node.getBNumber() < currentRoot.getBNumber()) {
            currentRoot.left = insertRec(currentRoot.left, node);
        } else if (node.getBNumber() > currentRoot.getBNumber()) {
            currentRoot.right = insertRec(currentRoot.right, node);
        }

        return currentRoot;
    }

    // Insert node and register backup nodes
    public void insert(int BNumber, String firstName, Node backup1, Node backup2, Node backup3) {
        root = insertRec(root, BNumber, firstName, backup1, backup2, backup3);
    }

    private Node insertRec(Node root, int BNumber, String firstName, Node backup1, Node backup2, Node backup3) {
        if (root == null) {
            Node newNode = new Node(BNumber, firstName);
            newNode.registerObserver(backup1, new FilterAllImpl());
            newNode.registerObserver(backup2, new FilterAllImpl());
            newNode.registerObserver(backup3, new FilterPrimeImpl());

            return newNode;
        }

        if (BNumber < root.getBNumber()) {
            root.left = insertRec(root.left, BNumber, firstName, backup1, backup2, backup3);
        } else if (BNumber > root.getBNumber()) {
            root.right = insertRec(root.right, BNumber, firstName, backup1, backup2, backup3);
        }

        return root;
    }

    // Public method for in-order traversal
    public void inOrderTraversal(FileWriter fileWriter) throws IOException {
        inOrderRec(root, fileWriter);
    }

    // Recursive method for in-order traversal
    private void inOrderRec(Node root, FileWriter fileWriter) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        if (root != null) {
            inOrderRec(root.getLeft(), fileWriter);
            stringBuilder.append(root.bNumber+":"+root.firstName); // Print the contents of the node
            inOrderRec(root.getRight(), fileWriter);
        }
        fileWriter.write(stringBuilder.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringRec(root, sb);
        return sb.toString();
    }

    // Recursive method to build the string representation of the BST
    private void toStringRec(Node root, StringBuilder sb) {
        if (root != null) {
            toStringRec(root.getLeft(), sb);
            sb.append(root.toString()).append("\n"); // Append the contents of the node to the StringBuilder
            toStringRec(root.getRight(), sb);
        }
    }

    public int sumBNumbers() {
        return sumBNumbersRec(root);
    }

    private int sumBNumbersRec(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getBNumber() + sumBNumbersRec(node.left) + sumBNumbersRec(node.right);
    }

    public void incrementBNumbers(int UPDATE_VALUE) {
        incrementBNumbersRec(root, UPDATE_VALUE);
    }

    private void incrementBNumbersRec(Node node, int UPDATE_VALUE) {
        if (node == null) {
            return;
        }
        int valueToUpdate = node.getBNumber() + UPDATE_VALUE;
        node.setbNumber(valueToUpdate);
        node.notifyObservers(valueToUpdate, node.firstName);
        incrementBNumbersRec(node.left, UPDATE_VALUE);
        incrementBNumbersRec(node.right, UPDATE_VALUE);
    }

}
