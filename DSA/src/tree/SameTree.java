package src.tree;

import java.util.Stack;

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

    /**
     * LeetCode Problem: 100. Same Tree
     * Link: https://leetcode.com/problems/same-tree/
     *
     * This method provides an iterative solution to determine if two binary trees are the same.
     * Two trees are considered the same if they are structurally identical and the nodes have the same values.
     *
     * Technique: Iterative Depth-First Search (DFS) using a Stack
     *
     * @param p The root of the first binary tree.
     * @param q The root of the second binary tree.
     * @return true if the trees are the same, false otherwise.
     *
     * Time Complexity: O(N), where N is the minimum number of nodes in the two trees.
     *                  Each node is pushed onto and popped from the stack exactly once.
     * Space Complexity: O(H), where H is the height of the tree. This is due to the stack space.
     *                   In the worst case (skewed tree), H can be N. In the best case (balanced tree), H is log N.
     */
    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        // Initialize a stack to store pairs of nodes from both trees.
        // Each element in the stack is an array of two TreeNodes: [node from tree p, node from tree q].
        Stack<TreeNode[]> stack = new Stack<>();

        // Push the root nodes of both trees onto the stack to start the comparison.
        stack.push(new TreeNode[]{p,q});

        // Continue as long as there are nodes to compare in the stack.
        while(!stack.isEmpty()){
            // Pop a pair of nodes from the stack.
            TreeNode[] array = stack.pop();
            TreeNode node1 = array[0]; // Node from tree p
            TreeNode node2 = array[1]; // Node from tree q

            // If both nodes are null, it means we've reached the end of a branch in both trees
            // simultaneously, and they are identical at this point. So, we continue to the next pair.
            if (node1 == null && node2 == null){
                continue;
            }

            // If one node is null and the other is not, or if their values are different,
            // then the trees are not the same. Return false immediately.
            if (node1 == null || node2 == null || node1.val != node2.val){
                return false;
            }

            // If the current nodes are not null and have the same value,
            // push their left children onto the stack for future comparison.
            // The order of pushing (left then right) ensures a consistent traversal order (e.g., pre-order).
            stack.push(new TreeNode[]{node1.left, node2.left});
            // Push their right children onto the stack for future comparison.
            stack.push(new TreeNode[]{node1.right, node2.right});
        }

        // If the loop completes, it means all corresponding nodes were either both null or had the same value.
        // Therefore, the trees are identical.
        return true;
    }
}
