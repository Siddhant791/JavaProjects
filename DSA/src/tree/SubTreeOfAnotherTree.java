package tree;

/**
 * This class provides a solution to determine if a binary tree is a subtree of another tree.
 * LeetCode Problem 572: Subtree of Another Tree
 * Time Complexity: O(m * n) where m and n are the number of nodes in the trees
 * Space Complexity: O(h) where h is the height of the tree (recursion stack)
 */
public class SubTreeOfAnotherTree {
    /**
     * Represents a node in a binary tree.
     */
    public class TreeNode {
        int val;             // Value stored in the node
        TreeNode left;       // Reference to left child
        TreeNode right;      // Reference to right child

        TreeNode() {}        // Default constructor

        /**
         * Constructor with value initialization
         * @param val The value to be stored in the node
         */
        TreeNode(int val) { this.val = val; }

        /**
         * Constructor with value and child nodes initialization
         * @param val The value to be stored in the node
         * @param left The left child node
         * @param right The right child node
         */
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        /**
         * Checks if subRoot tree is a subtree of root tree.
         * @param root The root of the main tree
         * @param subRoot The root of the tree to be checked as subtree
         * @return true if subRoot is a subtree of root, false otherwise
         */
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (subRoot == null) {         // Empty subtree is always a valid subtree
                return true;
            }
            if (root == null) {            // Empty main tree cannot contain a non-empty subtree
                return false;
            }

            // Check if current root matches the subtree pattern
            if(isCompleteTree(root, subRoot)) {
                return true;
            }

            // Recursively check left and right subtrees
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        /**
         * Helper method to check if two trees are identical in structure and values.
         * @param root First tree's root node
         * @param subRoot Second tree's root node
         * @return true if trees are identical, false otherwise
         */
        private boolean isCompleteTree(TreeNode root, TreeNode subRoot) {
            // If both nodes are null, trees are identical
            if (root == null && subRoot == null) {
                return true;
            }

            // If both nodes exist and have same value, check their subtrees
            if (root != null && subRoot != null && root.val == subRoot.val) {
                return (isCompleteTree(root.left, subRoot.left) &&
                        isCompleteTree(root.right, subRoot.right));
            }

            // In all other cases, trees are not identical
            return false;
        }
    }
}