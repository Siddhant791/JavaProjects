package src.Arrays;

public class DesignHashMap {

}


// LeetCode: https://leetcode.com/problems/design-hashmap/
// Problem: 706. Design HashMap
// Technique / Pattern: Hash Table with Separate Chaining (using singly linked lists for buckets)
// Summary:
// - Uses an array of buckets (fixed size) where each bucket is a linked list of NodeHashMap to handle collisions.
// - Average-case time complexity for put/get/remove: O(1) (assuming good hash distribution).
// - Worst-case time complexity for put/get/remove: O(n) (all keys collide into a single bucket).
// - Space complexity: O(n + k) where n is number of stored key-value pairs and k is number of buckets (here k = 1_000_000).
// Notes:
// - This implementation uses a fixed bucket array size of 1_000_000. That reduces collisions but increases memory usage.
// - Alternative approaches: dynamic resizing, using a prime number of buckets, or using other chaining structures (e.g., balanced trees) to guarantee better worst-case time.

// Node class for each key-value pair stored in a bucket (linked list node)
class NodeHashMap {
    public int key;
    public int value;
    public NodeHashMap next;

    public NodeHashMap(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

// MyHashMap using separate chaining
class MyHashMap {

    // Array of bucket heads. Each index holds the head of a linked list (nullable).
    NodeHashMap[] map;

    public MyHashMap() {
        // Initialize bucket array. Large fixed size to reduce collisions.
        this.map = new NodeHashMap[1000000];
    }

    public void put(int key, int value) {
        int hashValue = hash(key); // compute bucket index (O(1))
        NodeHashMap node = map[hashValue];

        // If bucket is empty, insert new node as head (O(1) time).
        if ( node == null) {
            map[hashValue] = new NodeHashMap(key, value);
            return;
        }

        // Traverse the chain to find if key exists. We check node.next in loop to allow handling tail insertion after loop.
        while(node.next != null) {
            if (node.key == key){
                // Key found in intermediate node: update value (O(1) for update).
                node.value = value;
                return;
            }
            node = node.next; // move to next node in chain (O(1) per step)
        }

        // After loop, node is last element in chain. Check last node for matching key.
        if (node.key == key){
            node.value = value; // update existing key at tail
            return; // important: return to avoid adding duplicate node
        }

        // Key not found in chain: append new node at tail (amortized O(1))
        node.next = new NodeHashMap(key, value);
    }

    public int get(int key) {
        int hashValue = hash(key); // compute bucket index
        NodeHashMap node = map[hashValue];
        if (node == null) {
            // bucket empty: key not present
            return -1;
        }

        // Traverse chain to find key: linear in chain length
        while(node!=null) {
            if (node.key == key) {
                // Found key: return associated value
                return node.value;
            }
            node = node.next;
        }
        // Not found in chain
        return -1;
    }

    public void remove(int key) {
        int hashValue = hash(key); // compute bucket index
        NodeHashMap node = map[hashValue];
        if (node == null) {
            // bucket empty: nothing to remove
            return;
        }

        // If head matches key, remove by pointing bucket to head.next
        if (node.key == key) {
            map[hashValue] = node.next;
            return;
        }

        // Otherwise, traverse chain and remove matching next node when found.
        // We keep reference to previous node via current node to unlink target.
        while (node.next != null) {
            if (node.next.key == key){
                // Unlink node.next to remove it from chain
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }

    public int hash(int key){
        // Simple modulo-based hash to map key into bucket array range.
        // Note: negative keys would produce negative modulus in Java; if negative keys are possible,
        // consider using Math.abs(key) or (key % size + size) % size to ensure non-negative index.
        return key%1000000;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
