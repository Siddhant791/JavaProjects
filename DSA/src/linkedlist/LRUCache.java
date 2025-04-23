package linkedlist;

import java.util.HashMap;
import java.util.Map;

// Node class to represent a doubly linked list node
class Node {
    public int key; // Key of the node
    public int value; // Value of the node
    public Node prev; // Pointer to the previous node
    public Node next; // Pointer to the next node

    // Constructor to initialize a node with a key and value
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

// LRUCache class implementing a Least Recently Used (LRU) Cache
public class LRUCache {

    private int capacity; // Maximum capacity of the cache
    private Map<Integer, Node> map = new HashMap<>(); // HashMap to store key-node pairs
    private Node head = new Node(0, 0); // Dummy head node for the doubly linked list
    private Node tail = new Node(0, 0); // Dummy tail node for the doubly linked list

    // Constructor to initialize the LRUCache with a given capacity
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail; // Connect head to tail
        tail.prev = head; // Connect tail to head
    }

    // Method to get the value of a key from the cache
    public int get(int key) {
        if(map.containsKey(key)){
            Node getNode = map.get(key); // Retrieve the node from the map
            remove(getNode); // Remove the node from its current position
            insert(getNode); // Insert the node at the front (most recently used)
            return getNode.value; // Return the value of the node
        }else{
            return -1; // Return -1 if the key is not found
        }
    }

    // Method to put a key-value pair into the cache
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key); // Retrieve the existing node
            remove(node); // Remove the node from its current position
        }
        Node node = new Node(key, value); // Create a new node
        insert(node); // Insert the node at the front (most recently used)
        map.put(key, node); // Add the node to the map

        if (map.size() > capacity) { // Check if the cache exceeds its capacity
            Node nodeToRemove = tail.prev; // Identify the least recently used node
            map.remove(nodeToRemove.key); // Remove the node from the map
            remove(nodeToRemove); // Remove the node from the doubly linked list
        }
    }

    // Helper method to remove a node from the doubly linked list
    private void remove(Node node){
        Node prev = node.prev; // Get the previous node
        Node next = node.next; // Get the next node
        prev.next = next; // Update the next pointer of the previous node
        next.prev = prev; // Update the prev pointer of the next node
    }

    // Helper method to insert a node at the front of the doubly linked list
    private void insert(Node node){
        Node first = head.next; // Get the first node after the head
        head.next = node; // Update the next pointer of the head
        node.prev = head; // Update the prev pointer of the new node
        first.prev = node; // Update the prev pointer of the first node
        node.next = first; // Update the next pointer of the new node
    }

}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
