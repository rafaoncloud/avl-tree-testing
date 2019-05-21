package test.main.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AVLTree {

    public main.java.AVLTree avlt;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        avlt = new main.java.AVLTree();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    /* -------------------------------------- */
    /* -------- Control-Flow Testing -------- */
    /* -------------------------------------- */

    // ----
    // Insert Method
    // ----

    @Test
    public void insertP1CreateTree() {
        //P1 = {1,2,16} - First Node Created
        main.java.AVLTree emptyTree = new main.java.AVLTree();
        emptyTree.insert(10);
        assertNotNull(emptyTree, "The three should not be null!");
    }

    @Test
    public void insertP2NoDuplicates() {
        //P2 = {1,3,9,16} - Not allows duplicated
        main.java.AVLTree avlt = new main.java.AVLTree();
        avlt.insert(10);
        assertEquals(1,avlt.countNodes());
        avlt.insert(10);
        assertEquals(1,avlt.countNodes(), "The tree allows duplicated values!");
    }

    @Test
    public void insertP3NoRotationLeft() {
        //P3 =  {1,3,4,5,16} - Insert left without rotations
        main.java.AVLTree avlt = new main.java.AVLTree();
        avlt.insert(0);
        avlt.insert(-10);
        assertEquals("0 -10", avlt.preorder(), "The value should be inserted left without rotation!");
    }

    @Test
    public void insertP4Rotate1Right() {
        //P4 =  {1,3,4,5,6,7,16} - Rotate 1R
        main.java.AVLTree avlt = new main.java.AVLTree();
        avlt.insert(0);
        avlt.insert(-10);
        System.out.println("Preorder: " + avlt.preorder());
        avlt.insert(-15);
        assertEquals("-10 -15 0", avlt.preorder(), "The tree should rotate 1R!");
    }

    @Test
    public void insertP5Rotate2Right() {
        //P5 =  {1,3,4,5,6,8,16} - Rotate 2R
        main.java.AVLTree avlt = new main.java.AVLTree();
        avlt.insert(0);
        avlt.insert(-10);
        System.out.println("Preorder: " + avlt.preorder());
        avlt.insert(-5);
        assertEquals("-5 -10 0", avlt.preorder(), "The tree should rotate 2R!");
    }

    @Test
    public void insertP6NoRotationRight() {
        //P6 =  {1,3,9,10,11,16} - Rotate 2R
        main.java.AVLTree avlt = new main.java.AVLTree();
        avlt.insert(0);
        avlt.insert(10);
        assertEquals("0 10", avlt.preorder(), "The value should be inserted right without rotation!");
    }

    @Test
    public void insertP7Rotate2Left() {
        //P7 =  {1,3,9,10,11,12,14,16} - Rotate 2L
        main.java.AVLTree avlt = new main.java.AVLTree();
        avlt.insert(0);
        avlt.insert(10);
        System.out.println("Preorder: " + avlt.preorder());
        avlt.insert(5);
        assertEquals("5 0 10", avlt.preorder(),"The tree should rotate 2L!");
    }

    @Test
    public void insertP8Rotate1Left() {
        //P8 =  {1,3,9,10,11,12,13,16} - Rotate 1L
        main.java.AVLTree avlt = new main.java.AVLTree();
        avlt.insert(0);
        avlt.insert(10);
        System.out.println("Preorder: " + avlt.preorder());
        avlt.insert(15);
        assertEquals("10 0 15",avlt.preorder(), "The value should rotate 1L!");
    }

    // ----
    // Search Method
    // ----

    @Test
    void searchP1TreeIsEmpty() {
        boolean found;
        main.java.AVLTree avlt = new main.java.AVLTree();

        found = avlt.search(10);
        assertEquals(false, found,"The is empty, therefore the search result should not be true!");
    }

    @Test
    void searchP2ValueInTheNode() {
        //  P2 = {1,2,3,4,5,7,9,11} - Value in the node...
        boolean found;                                                                             
        main.java.AVLTree avlt = new main.java.AVLTree();                                          

        avlt.insert(10);

        found = avlt.search(10);                                                                   
        assertEquals(true, found,"The value is in the given node!");
    }

    // Weird behavior with recursive methods
    @Test
    void searchP3SmallerThanMainNode() {
        // P1 = {1,(2,3,4,5,6,10),2,3,4,5,7,9,11} - The value is smaller than the one in the main node
        boolean found;
        main.java.AVLTree avlt = new main.java.AVLTree();

        avlt.insert(0);
        avlt.insert(-10);
        found = avlt.search(-15);

        assertEquals(false, found,"The value should be false!");
    }

    // Weird behavior with recursive methods
    @Test
    void searchP4LargerThanMainNode() {
        // P1 = {1,(2,3,4,5,6,10),2,3,4,5,7,9,11} - The value is larger than the one in the main node
        boolean found;
        main.java.AVLTree avlt = new main.java.AVLTree();

        avlt.insert(0);
        avlt.insert(10);
        found = avlt.search(15);

        assertEquals(false, found,"The value should be false!");
    }

    // Weird behavior with recursive methods
    @Test
    void searchP5SmallerThanMainNodeAndFoundFirstRound() {
        // P1 = {1,(2,3,4,5,6,10),2,3,4,5,7,9,11} - The value is larger than the one in the main node
        boolean found;
        main.java.AVLTree avlt = new main.java.AVLTree();

        avlt.insert(0);
        avlt.insert(-10);
        found = avlt.search(-15);

        assertEquals(false, found,"The value should be false!");
    }
}