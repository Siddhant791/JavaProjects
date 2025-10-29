package src.tree;

/*
 LeetCode: https://leetcode.com/problems/validate-binary-search-tree/
 Problem: Validate Binary Search Tree (LC 98)
 Technique/Pattern: Depth-First Search (DFS) recursion with range/bounds checking (divide and conquer).

 Explanation:
 - Maintain a valid value range (exclusive) for every node: (leftBound, rightBound).
 - For each node, its value must be strictly greater than leftBound and strictly less than rightBound.
 - Recurse left with updated rightBound = node.val and recurse right with updated leftBound = node.val.
 - Use long bounds to avoid integer overflow when node values may be Integer.MIN_VALUE or Integer.MAX_VALUE.

 Time Complexity: O(n) where n is number of nodes (each node visited once).
 Space Complexity: O(h) where h is tree height (recursion stack). Worst-case O(n) for skewed tree, O(log n) for balanced tree.
*/
public class ValdiBST {
    public boolean isValidBST(TreeNode root) {
        // Start with the widest possible exclusive bounds.
        // Use Long.MIN_VALUE and Long.MAX_VALUE to safely handle Integer edge values.
        return helper(root,  Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode node, long left, long right){
        // Inline comment: null nodes are valid BSTs by definition.
        if (node == null) {
            return true;
        }

        // Inline comment: current node must satisfy strict inequality with the bounds.
        // If it doesn't, this subtree is not a valid BST.
        if (!(left < node.val && right > node.val)){
            return false;
        }

        // Inline comment: recurse left and right with updated bounds.
        // Left subtree must be within (left, node.val), right subtree within (node.val, right).
        return helper(node.left, left, node.val) && helper(node.right, node.val, right);
    }
}