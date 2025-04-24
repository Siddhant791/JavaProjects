package tree;

public class InvertBinaryTree {

    /**
     * Represents a node in a binary tree.
     */
    public class TreeNode {
        int val; // Value of the node
        TreeNode left; // Left child of the node
        TreeNode right; // Right child of the node

        TreeNode() {} // Default constructor

        /**
         * Constructor for TreeNode with a value.
         *
         * @param val The value of the node.
         */
        TreeNode(int val) {
            this.val = val;
        }

        /**
         * Constructor for TreeNode with a value, left child, and right child.
         *
         * @param val The value of the node.
         * @param left The left child of the node.
         * @param right The right child of the node.
         */
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Inverts a binary tree by swapping the left and right children of all nodes.
     *
     * @param root The root of the binary tree.
     * @return The root of the inverted binary tree.
     */
    public TreeNode invertTree(TreeNode root) {
        invertTheTree(root); // Call the helper method to perform the inversion
        return root; // Return the root of the inverted tree
    }

    /**
     * Helper method to recursively invert a binary tree.
     *
     * @param root The current node in the binary tree.
     */
    private void invertTheTree(TreeNode root) {
        if (root == null) { // Base case: if the current node is null, return
            return;
        }

        // Recursively invert the left subtree
        invertTheTree(root.left);

        // Recursively invert the right subtree
        invertTheTree(root.right);

        // Swap the left and right children of the current node
        TreeNode temp = root.left; // Store the left child in a temporary variable
        root.left = root.right; // Assign the right child to the left
        root.right = temp; // Assign the temporary variable (original left) to the right
    }
}