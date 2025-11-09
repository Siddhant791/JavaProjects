package src.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    // LeetCode: https://leetcode.com/problems/binary-tree-postorder-traversal/
    // Problem: Binary Tree Postorder Traversal (post-order: left -> right -> root)
    // Patterns / Techniques:
    //  - Recursive: straightforward DFS post-order traversal.
    //  - Iterative: use a stack and the "reverse preorder" trick (visit root -> right -> left,
    //    collect nodes and then reverse the result to obtain left -> right -> root).
    //
    // Complexity (both approaches):
    //  - Time: O(n) where n is the number of nodes (each node visited once).
    //  - Space:
    //      * Recursive: O(h) call stack worst-case O(n) for skewed tree, plus O(n) for output.
    //      * Iterative: O(n) worst-case for stack and output.
    //
    // Note: `output` is a class-level list used by the recursive method. Reusing this instance
    // across multiple calls will accumulate results. To avoid that, prefer creating a new list
    // per call (not modifying existing code as requested).
    List<Integer> output = new ArrayList<>();

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        // Iterative postorder using a stack and reverse of modified preorder.
        // If root is null, return empty list immediately.
        if (root == null ){
            return new ArrayList<>();
        }
        // Stack used to simulate recursion (LIFO).
        Stack<TreeNode> stack = new Stack<>();
        // Result will store nodes in root->right->left order, then we reverse it.
        List<Integer> result = new ArrayList<>();

        // Initialize stack with root to start traversal.
        stack.add(root);

        // Current pointer used to traverse right children first.
        TreeNode curr = root;

        // Loop until all nodes processed (stack empty).
        while(!stack.isEmpty()){
            if (curr != null){
                // Visit current node (root of current subtree).
                result.add(curr.val);
                // Push current node to stack to later explore its left subtree.
                stack.add(curr);
                // Move to right child to follow modified preorder (root, right, left).
                curr = curr.right;
            }else {
                // When no current node, pop previously seen node and switch to its left subtree.
                curr = stack.pop();
                curr = curr.left;
            }
        }

        // Reverse collected order (root->right->left) to get left->right->root (postorder).
        Collections.reverse(result);

        return result;
    }

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        // Recursive DFS post-order.
        // Caution: uses the class-level `output`; it is not reset here.
        if (root == null ){
            return output;
        }

        // Traverse left subtree first.
        postorderTraversalRecursive(root.left);
        // Then traverse right subtree.
        postorderTraversalRecursive(root.right);
        // Finally visit root.
        output.add(root.val);
        return output;
    }
}
