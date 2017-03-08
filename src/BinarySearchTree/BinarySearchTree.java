package BinarySearchTree;

public class BinarySearchTree {


    private class Node {
        private int key;
        private Node right;
        private Node left;
        private Node parent;

        private Node(int key) {
            this.key = key;
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = 31 * result + key;
            return result;
        }

        @Override
        public String toString() {
            return ("Key - " + key + "; Parent - " + parent.key + "; Right Child - " + right.key + "; Left Child - " + left.key);
        }
    }

    private Node root;

    public Node find(int key) {
        Node tempNode = root;
        if (tempNode == null) return null;
        while (tempNode.key != key) {
            if (tempNode.key < key) tempNode = tempNode.right;
            else tempNode = tempNode.left;
            if (tempNode == null) return null;
        }
        return tempNode;
    }

    public boolean isFind(int key) {
        return find(key) != null;
    }

    public void addNode(int key) {
        Node newNode = new Node(key);
        Node parentNode;
        if (!isFind(key)) {
            if (root == null) root = newNode;
            else {
                Node tempNode = root;
                while (tempNode != newNode) {
                    parentNode = tempNode;
                    if (key > tempNode.key) {
                        tempNode = tempNode.right;
                        if (tempNode == null) {
                            parentNode.right = newNode;
                            newNode.parent = parentNode;
                            tempNode = newNode;
                        }
                    } else {
                        tempNode = tempNode.left;
                        if (tempNode == null) {
                            parentNode.left = newNode;
                            newNode.parent = parentNode;
                            tempNode = newNode;
                        }
                    }
                }
            }
        }
    }


    public void remove(int key) {
        Node delNode = find(key);
        if (delNode != null) {
            Node parentNode = delNode.parent;
            Node leftChild = delNode.left;
            Node rightChild = delNode.right;
            if (leftChild == null && rightChild == null) {
                if (key > parentNode.key) parentNode.right = null;
                else parentNode.left = null;
            } else if (leftChild == null) {
                if (key > parentNode.key) parentNode.right = rightChild;
                else parentNode.left = rightChild;
                rightChild.parent = parentNode;
            } else if (rightChild == null) {
                if (key > parentNode.key) parentNode.right = leftChild;
                else parentNode.left = leftChild;
                leftChild.parent = parentNode;
            } else {
                if (leftChild.right == null) {
                    if (key > parentNode.key) parentNode.right = leftChild;
                    else parentNode.left = leftChild;
                    leftChild.right = delNode.right;
                } else {
                    Node tempNode = leftChild.right;
                    Node tempParent = leftChild;
                    while (tempNode.right != null) {
                        tempParent = tempNode;
                        tempNode = tempNode.right;
                    }
                    delNode.key = tempNode.key;
                    if (tempNode.left == null) tempParent.right = null;
                    else {
                        tempParent.right = tempNode.left;
                        tempNode.left.parent = tempParent;
                    }
                }
            }
        }
    }

    public String neighbors(int key) {
        Node node = find(key);
        return ("Parent - " + node.parent.key + "; Right Child - " + node.right.key + "; Left Child - " + node.left.key);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj instanceof Node) {
            Node other = (Node) obj;
            return ((Node) obj).key == other.key;
        }
        return false;
    }
}
