package tree;

/**
 * This class provides a method to find the k-th smallest element in a Binary Search Tree (BST).
 */
public class FindKthLowestElementInABstTree {

    /**
     * Represents a node in a binary tree.
     */
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;

        /**
         * Default constructor for TreeNode.
         */
          TreeNode() {}

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
     * Finds the k-th smallest element in a BST.
     *
     * @param root The root of the BST.
     * @param k The k-th position to find (1-based index).
     * @return The value of the k-th smallest element.
     */
/**
          * Finds the k-th smallest element in a BST.
          *
          * @param root The root of the BST.
          * @param k The k-th position to find (1-based index).
          * @return The value of the k-th smallest element.
          */
         public int kthSmallest(TreeNode root, int k) {
             int[] output = new int[2]; // Array to store the remaining k value and the result
             output[0] = k; // Initialize the remaining k value
             calculateKthSmallestElement(root, output); // Start the recursive search
             return output[1]; // Return the k-th smallest value
         }

         /**
          * Helper method to recursively calculate the k-th smallest element in a BST.
          *
          * @param root The current node in the BST.
          * @param output An array where output[0] is the remaining k value and output[1] stores the result.
          */
         private void calculateKthSmallestElement(TreeNode root, int[] output) {
             if (root == null) { // Base case: if the current node is null, return
                 return;
             }
             calculateKthSmallestElement(root.left, output); // Recur on the left subtree
             output[0] -= 1; // Decrement the remaining k value
             if (output[0] == 0) { // If k becomes 0, we have found the k-th smallest element
                 output[1] = root.val; // Store the result
             }
             calculateKthSmallestElement(root.right, output); // Recur on the right subtree
         }
}
