package src.tree;

/**
 * LeetCode Problem: 100. Same Tree
 * Link: https://leetcode.com/problems/same-tree/
 *
 * This class provides a solution to determine if two binary trees are the same.
 * Two trees are considered the same if they are structurally identical and the nodes have the same values.
 *
 * Technique: Recursion (Depth-First Search - DFS)
 */
public class SameTree {
    /**
     * Checks if two binary trees are structurally identical and have the same node values.
     *
     * @param p The root of the first binary tree.
     * @param q The root of the second binary tree.
     * @return true if the trees are the same, false otherwise.
     *
     * Time Complexity: O(N), where N is the minimum number of nodes in the two trees.
     *                  In the worst case, we visit each node once.
     * Space Complexity: O(H), where H is the height of the tree. This is due to the recursion stack.
     *                   In the worst case (skewed tree), H can be N. In the best case (balanced tree), H is log N.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base Case 1: If both nodes are null, they are considered the same at this point.
        // Base Case 2: If one node is null and the other is not, they are not the same.
        if (p == null || q == null){
            return (p == null && q == null);
        }

        // If the values of the current nodes are different, the trees are not the same.
        if (p.val != q.val){
            return false;
        }

        // Recursively check the left subtrees and the right subtrees.
        // Both left and right subtrees must be identical for the overall trees to be identical.
        return (isSameTree(p.left,q.left) && isSameTree(p.right, q.right));
    }
}
