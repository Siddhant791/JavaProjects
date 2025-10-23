package src.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode Problem: 102. Binary Tree Level Order Traversal
 * Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Technique: Breadth-First Search (BFS) / Level Order Traversal using a Queue.
 *
 * This problem asks us to traverse a binary tree level by level and return the
 * node values of each level as a list of lists.
 *
 * Time Complexity: O(N), where N is the number of nodes in the tree.
 * Each node is visited and processed exactly once (added to the queue, polled from the queue).
 *
 * Space Complexity: O(W), where W is the maximum width of the tree.
 * In the worst case (a complete binary tree), the queue can hold up to N/2 nodes,
 * which is proportional to N. So, it can be O(N) in the worst case.
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        // Base case: If the tree is empty, return an empty list of lists.
        if (root == null){
            return new ArrayList<>();
        }

        // 'out' will store the final result, where each inner list represents a level.
        List<List<Integer>> out = new ArrayList<>();

        // A queue is used for BFS to process nodes level by level.
        Queue<TreeNode> queue = new LinkedList<>();

        // Start the BFS by adding the root node to the queue.
        queue.add(root);

        // Continue as long as there are nodes to process in the queue.
        while (!queue.isEmpty()){

            // 'levelSize' stores the number of nodes at the current level.
            // This is crucial for processing one level at a time.
            int levelSize = queue.size();
            // 'insideList' will store the values of nodes at the current level.
            List<Integer> insideList = new ArrayList<>();

            // Process all nodes at the current level.
            // We iterate 'levelSize' times to ensure we only process nodes from the current level.
            for (int i = 0; i < levelSize; i++) {
                // Dequeue a node from the front of the queue.
                TreeNode node = queue.poll();
                // Add the node's value to the current level's list.
                insideList.add(node.val);

                // If the left child exists, add it to the queue for the next level.
                if (node.left != null){
                    queue.add(node.left);
                }
                // If the right child exists, add it to the queue for the next level.
                if (node.right != null){
                    queue.add(node.right);
                }
            }

            // After processing all nodes at the current level, add the 'insideList' to the 'out' list.
            // This check ensures we don't add empty lists if somehow 'insideList' was empty (though it shouldn't be here).
            if (!insideList.isEmpty()){
                out.add(insideList); // No need to create a new ArrayList if insideList is already distinct for this level.
            }

        }

        // Return the list of lists, representing the level order traversal.
        return out;
    }
}
