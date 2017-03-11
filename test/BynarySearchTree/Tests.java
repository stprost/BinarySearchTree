package BynarySearchTree;

import org.junit.Test;

import static org.junit.Assert.*;

import BinarySearchTree.BinarySearchTree;

public class Tests {
    private BinarySearchTree bst = new BinarySearchTree();

    @Test
    public void contains() {
        bst.addNode(10);
        bst.addNode(5);
        bst.addNode(8);
        bst.addNode(3);
        bst.addNode(13);
        bst.addNode(11);
        bst.addNode(15);
        assertTrue(bst.contains(10));
        assertTrue(bst.contains(8));
        assertTrue(bst.contains(11));
        assertFalse(bst.contains(2));
        assertFalse(bst.contains(-13));
        assertFalse(bst.contains(1));
    }

    @Test
    public void remove() {
        bst.addNode(1);
        bst.addNode(20);
        bst.addNode(30);
        bst.addNode(15);
        bst.addNode(17);
        bst.addNode(14);
        bst.remove(20);
        assertFalse(bst.contains(20));
    }

    @Test
    public void neighbors() {
        bst.addNode(1);
        bst.addNode(20);
        bst.addNode(15);
        bst.addNode(17);
        bst.addNode(14);
        assertEquals("Parent - 20; Right Child - 17; Left Child - 14", bst.neighbors(15));
    }
}
