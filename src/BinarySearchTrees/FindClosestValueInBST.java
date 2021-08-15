package BinarySearchTrees;

public class FindClosestValueInBST {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueHelper(tree, target, Integer.MAX_VALUE);
    }

    public static int findClosestValueHelper(BST tree, int target, int closest) {
        if (tree == null) {
            return closest;
        }
        if (Math.abs(target - closest) > Math.abs(target - tree.value)) {
            closest = tree.value;
        }
        if (target < tree.value) {
            return findClosestValueHelper(tree.left, target, closest);
        }
        else if (target > tree.value) {
            return findClosestValueHelper(tree.right, target, closest);
        }
        else {
            return closest;
        }
    }
}
