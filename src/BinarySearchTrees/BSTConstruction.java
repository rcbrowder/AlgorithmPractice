package BinarySearchTrees;

/**
 * Binary Search Tree Construction
 */
public class BSTConstruction {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        /**
         * Insert new value to BST
         * @param value Value at Node
         * @return BST with new Node inserted
         */
        public BST insert(int value) {
            BST currentNode = this;
            while (true) {
                if (value < currentNode.value) {
                    if (currentNode.left == null) {
                        currentNode.left = new BST(value);
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = new BST(value);
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
            return this;
        }

        /**
         * Check if BST contains value.
         * @param value Value to check for in BST
         * @return True if BST contains value, false if it does not
         */
        public boolean contains(int value) {
            BST currentNode = this;
            while (currentNode != null) {
                if (value < currentNode.value) {
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    currentNode = currentNode.right;
                } else {
                    return true;
                }
            }
            return false;
        }

        /**
         * Remove first instance of value from BST
         * @param value Value to remove first instance of from BST
         * @return BST with first instance of given value removed
         */
        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        /**
         * Helper method for removing first instance of value from BST
         * @param value Value to remove first instance of from BST
         * @param parentNode Parent node of current node being tested for removal
         * @return BST with nodes reorganized after node removal
         */
        public BST remove(int value, BST parentNode) {
            BST currentNode = this;
            while (currentNode != null) {
                if (value < currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                } else {
                    if (currentNode.left != null && currentNode.right != null) {
                        currentNode.value = currentNode.right.getMinValue();
                        // currentNode.value = smallest value of right subtree
                        currentNode.right.remove(currentNode.value, currentNode);
                    } else if (parentNode == null) {
                        if (currentNode.left != null) {
                            currentNode.value = currentNode.left.value;
                            currentNode.right = currentNode.left.right;
                            currentNode.left = currentNode.left.left;
                        } else if (currentNode.right != null) {
                            currentNode.value = currentNode.right.value;
                            currentNode.left = currentNode.right.left;
                            currentNode.right = currentNode.right.right;
                        }
                    } else if (parentNode.left == currentNode) {
                        parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                    } else if (parentNode.right == currentNode) {
                        parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                    }
                    break;
                }
            }
            return this;
        }

        /**
         * Get minimum value in BST
         * @return Minimum value
         */
        private int getMinValue() {
            BST currentNode = this;
            while (currentNode.left != null) {
                currentNode = currentNode.left;
            }
            return currentNode.value;
        }
    }
}
