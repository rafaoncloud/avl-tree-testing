package main.java;

/* Class AVLNode */
public class AVLNode {
    // public variables for testing purposes

    public AVLNode left, right;
    public int data;
    public int height;

    /* Constructor */
    public AVLNode() {
        left = null;
        right = null;
        data = 0;
        height = 0;
    }

    /* Constructor */
    public AVLNode(int n) {
        left = null;
        right = null;
        data = n;
        height = 0;
    }
}

