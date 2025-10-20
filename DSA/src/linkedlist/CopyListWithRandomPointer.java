package src.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    /**
     * LeetCode Problem: 138. Copy List with Random Pointer
     * Link: https://leetcode.com/problems/copy-list-with-random-pointer/
     *
     * This problem asks us to create a deep copy of a linked list where each node
     * has an additional 'random' pointer that can point to any node in the list
     * or to null.
     *
     * Technique: Hashing (using a HashMap)
     *
     * The core idea is to use a hash map to store the mapping between original nodes
     * and their corresponding new (copied) nodes. This allows us to efficiently
     * retrieve the copied node for any given original node, which is crucial
     * when setting the 'next' and 'random' pointers of the copied nodes.
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * We iterate through the linked list twice. The first pass creates all new nodes
     * and populates the hash map. The second pass sets the 'next' and 'random' pointers
     * for the new nodes. Each hash map operation (put, get) takes O(1) on average.
     * Therefore, the total time complexity is O(N) + O(N) = O(N), where N is the number of nodes in the list.
     *
     * Space Complexity: O(N)
     * The hash map stores a mapping for each of the N nodes in the original list.
     * In the worst case, all N nodes will be stored in the map.
     * Therefore, the space complexity is O(N).
     */
    public Node copyRandomList(Node head) {
        // Step 1: Create a mapping from original nodes to new nodes.
        // This map will store (original_node -> copied_node) pairs.
        Map<Node,Node> map = new HashMap<>();
        // Handle the null case: if the head is null, the copy is also null.
        // This also helps in setting 'next' and 'random' pointers to null correctly
        // when an original pointer is null.
        map.put(null,null);

        // First pass: Create all new nodes and populate the map.
        Node temp = head;
        while (temp!=null){
            // Create a new node with the same value as the original node.
            Node newNode = new Node(temp.val);
            // Store the mapping: original node -> new node.
            map.put(temp,newNode);
            // Move to the next original node.
            temp = temp.next;
        }

        // Second pass: Set the 'next' and 'random' pointers for the new nodes.
        // We iterate through the original list again.
        temp = head;
        while (temp!=null){
            // Get the copied node corresponding to the current original node.
            Node copy = map.get(temp);
            // Set the 'next' pointer of the copied node.
            // We use the map to find the copied version of temp.next.
            copy.next = map.get(temp.next);
            // Set the 'random' pointer of the copied node.
            // We use the map to find the copied version of temp.random.
            copy.random = map.get(temp.random);
            // Move to the next original node.
            temp = temp.next;
        }

        // The head of the new list is the copied version of the original head.
        return map.get(head);
    }

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
