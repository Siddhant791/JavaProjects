package src.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 104 - Maximum Depth of Binary Tree
 *
 * Problem Statement:
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 *
 * Example:
 * Input: root = [3,9,20,null,null,15,7]
 *      3
 *     / \
 *    9  20
 *       / \
 *      15  7
 * Output: 3
 *
 * Pattern Used: Depth-First Search (DFS) with Recursion
 * - Uses recursive DFS to explore each path to its leaf
 * - Bottom-up approach where depth is calculated as we return from recursion
 * - Post-order traversal pattern (process after visiting children)
 *
 * Time Complexity: O(n) where n is the number of nodes
 * - We must visit each node exactly once
 * - Each node operation is O(1)
 *
 * Space Complexity: O(h) where h is the height of the tree
 * - In worst case (skewed tree), h = n, making it O(n)
 * - In best case (balanced tree), h = log n
 * - Space is used by the recursive call stack
 */
public class MaximumDepthOfBinaryTree {

    /**
     * Definition for a binary tree node
     * Each node contains a value and references to left and right children
     */
    static class MyTreeNode {
        int val;             // Node's value
        MyTreeNode left;     // Reference to left child
        MyTreeNode right;    // Reference to right child

        MyTreeNode(int x) {
            val = x;
        }
    }
    
    /**
     * Calculates maximum depth using recursive DFS
     *
     * Algorithm:
     * 1. Base case: if node is null, depth is 0
     * 2. Recursively calculate depth of left and right subtrees
     * 3. Return max of left and right depths + 1 (for current node)
     *
     * @param root Root node of the binary tree
     * @return Maximum depth of the tree
     */
    public int maxDepth(MyTreeNode root) {
        // Base case: empty tree has depth 0
        if (root == null){
            return 0;
        }

        // Recursively find depth of left and right subtrees
        // Add 1 to account for current node
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * Calculates maximum depth using Breadth-First Search (BFS)
     *
     * Pattern Used: Level-order traversal with BFS
     * - Uses a queue to process nodes level by level
     * - Each level represents one depth unit
     * - Processes all nodes at current level before moving to next
     *
     * Time Complexity: O(n) where n is number of nodes
     * - Each node is processed exactly once
     * - Queue operations (add/poll) are O(1)
     *
     * Space Complexity: O(w) where w is the maximum width of tree
     * - In worst case (complete binary tree), w = n/2 ≈ O(n)
     * - Queue stores at most all nodes at the widest level
     *
     * @param root Root node of the binary tree
     * @return Maximum depth of the tree
     */
    public int maxDepthWithBFS(MyTreeNode root) {
        // Handle empty tree case
        if (root == null){
            return 0;
        }

        // Initialize queue for BFS and add root node
        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Track number of levels (depth) in the tree
        int level = 0;

        // Process nodes level by level until queue is empty
        while(!queue.isEmpty()){
            // Get number of nodes at current level
            int size = queue.size();

            // Process all nodes at current level
            for (int i = 0 ; i < size ; i++ ){
                // Remove current node from queue
                MyTreeNode current = queue.poll();

                // Add right child to queue if exists
                if (current.right != null){
                    queue.add(current.right);
                }

                // Add left child to queue if exists
                if (current.left != null){
                    queue.add(current.left);
                }
            }
            // Increment level after processing all nodes at current depth
            level++;
        }

        return level;
    }
}
