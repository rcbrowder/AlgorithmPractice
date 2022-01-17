package BinarySearchTrees;

import org.w3c.dom.Node;

public class ValidateBST {
    public static boolean validateBst(BST tree) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return isValid(tree, min, max);
    }

    public static boolean isValid(BST tree, int min, int max) {

        boolean leftValid;
        boolean rightValid;

        if (tree == null) return true;
        if (tree.value < min || tree.value >= max) return false;

        leftValid = isValid(tree.left, min, tree.value);
        rightValid = isValid(tree.right, tree.value, max);
        return leftValid && rightValid;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
