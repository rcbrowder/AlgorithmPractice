package BinaryTrees;

/**
 * Write a function that takes in a Binary Tree and inverts it. In other words, the function should swap every left
 * node in the tree for its corresponding right node.
 * 
 * Each BinaryTree node has an integer value, a left child node, and a right child node. Children nodes can either be
 * BinaryTree nodes themselves or None / null.
 */

public class InvertBinaryTree {

    public static void invertBinaryTree(BinaryTree tree) {
        swapNodes(tree);
    }

    private static void swapNodes(BinaryTree tree) {
        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
        if (tree.left != null) {
            swapNodes(tree.left);
        }
        if (tree.right != null) {
            swapNodes(tree.right);
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
