package src.tree;

/**
 * LeetCode 543 - Diameter of Binary Tree
 *
 * Problem Statement:
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes.
 * This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 * Example:
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * Output: 3 (path: 4->2->1->3 or 5->2->1->3)
 *
 * Technique Used:
 * - Depth First Search (DFS)
 * - Post-order traversal
 * - Bottom-up recursion approach
 */
public class DiameterOfTree {
    /**
     * Definition for a binary tree node
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Main method to calculate the diameter of the binary tree
     * Uses a helper method with DFS to track both height and diameter
     *
     * Time Complexity: O(n) - we visit each node exactly once
     * Space Complexity: O(h) - where h is the height of the tree due to recursion stack
     *                         In worst case (skewed tree): O(n)
     *                         In best case (balanced tree): O(log n)
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = new int[1];  // Using array to pass by reference
        maxHeight(root, result);
        return result[0];
    }

    /**
     * Helper method that performs DFS to calculate both height and diameter
     * For each node, calculates:
     * 1. Height of left and right subtrees
     * 2. Potential diameter passing through current node (left height + right height)
     * 3. Updates the maximum diameter found so far
     *
     * @param root Current node being processed
     * @param result Array to store the maximum diameter found (passed by reference)
     * @return Height of the current subtree
     */
    private int maxHeight(TreeNode root, int[] result){
        if (root == null){
            return 0;
        }

        // Post-order traversal: process left and right children first
        int left = maxHeight(root.left, result);    // Get height of left subtree
        int right = maxHeight(root.right, result);  // Get height of right subtree

        // Update the maximum diameter if path through current node is longer
        result[0] = Math.max(result[0], left + right);

        // Return height of current subtree
        return 1 + Math.max(left, right);
    }
}
