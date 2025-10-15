package src.tree;

// LeetCode: https://leetcode.com/problems/balanced-binary-tree/
// Problem: Balanced Binary Tree (LeetCode 110)
// Technique / Pattern: Depth-First Search (DFS) with post-order traversal. Compute subtree heights bottom-up and propagate an "is-balanced" flag.
// Overall Time Complexity: O(n) where n is the number of nodes (each node visited once).
// Overall Space Complexity: O(h) for recursion stack where h is tree height (O(n) worst-case, O(log n) for balanced trees).

public class BalancedSubTree {

    // Simple binary tree node container.
    // Time/Space: O(1) per node for storage.
    class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value){
            this.value = value;
        }
        public TreeNode(TreeNode left , TreeNode right, int value ){
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    // Public API to determine whether a binary tree is height-balanced.
    // Uses a helper DFS that returns subtree height and updates a boolean flag if imbalance is detected.
    //
    // Complexity:
    // - Time: O(n) — calls dfs exactly once per node.
    // - Space: O(h) recursion depth.
    public boolean isBalanced(TreeNode root) {
        Boolean[] output = new Boolean[1];
        output[0] = true;
        int depth = dfs(root, output);

        return output[0];
    }

    // Helper DFS that returns the height of the subtree rooted at `root`.
    // Uses post-order traversal: compute left and right heights before checking balance at current node.
    //
    // The Boolean[] `output` is used as a mutable flag to indicate if any subtree is unbalanced.
    // Alternative patterns: return -1 to indicate imbalance (commonly used); here a shared mutable container is used.
    //
    // Complexity (per call):
    // - Work per node: O(1)
    // - Combined complexity: O(n) total.
    public int dfs(TreeNode root, Boolean[] output){
        if (root == null){
            return 0;
        }

        int left = dfs(root.left, output);
        int right = dfs(root.right, output);

        if (Math.abs(left - right) > 1){
            output[0] = false;
        }

        return 1 + Math.max(left,right);
    }
}