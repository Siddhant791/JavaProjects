// LeetCode 705 - Design HashSet
// https://leetcode.com/problems/design-hashset/
//
// Problem summary:
// Implement a HashSet without using any built-in hash table libraries. Support add, remove and contains operations.
// Technique / Pattern: Hashing with separate chaining (bucket array of linked lists).
//
// Complexity analysis:
// - add(key): Average O(1) time, Worst-case O(n) time when many collisions place all keys in same bucket and you traverse the chain.
// - remove(key): Average O(1) time, Worst-case O(n).
// - contains(key): Average O(1) time, Worst-case O(n).
// - Space: O(n + B) where n is number of stored keys and B is number of buckets (here B = 10000). Extra memory for Node objects and the bucket array.
//
// Notes:
// - We use modulo hashing (key % 10000) to map keys to buckets. Choosing 10000 is arbitrary; in production you'd pick a prime or resize dynamically.
// - Separate chaining (linked lists) handles collisions. Alternatives: open addressing, dynamic resizing, or using balanced trees per bucket.

package src.Arrays;

public class DesignHashSet {

}

// Node class used for separate chaining linked list in each bucket.
class Node {
    public int value; // stored key value
    public Node next; // pointer to next node in chain

    public Node(int value){
        this.value = value; // initialize node with given key
    }
}

class MyHashSet {

    // Bucket array storing head node of linked list for each bucket.
    Node[] data;

    public MyHashSet() {
        // Initialize fixed number of buckets. Choosing 10000 as in many simple solutions.
        data = new Node[10000];
    }

    public void add(int key) {
        int hashValue = hash(key); // compute bucket index
        Node n = data[hashValue];

        if(n == null) {
            // If bucket empty, create new node and set as head. O(1) time.
            data[hashValue] = new Node(key);
            return;
        }

        // Traverse chain to check if key already exists or find the tail to append.
        while (n.next != null) {
            if (n.value == key){
                // Key already present; do nothing. Average O(1) if found early.
                return;
            }
            n = n.next; // move to next node in chain
        }

        // After loop, n is the tail node. Need to check tail value as loop stops at tail (n.next == null).
        if (n.value == key){
            // Key already present at tail; do nothing.
            return;
        }

        // Append new node at tail. This makes add O(1) for insertion once tail is reached.
        n.next = new Node(key);
    }

    public void remove(int key) {

        int hashValue = hash(key); // compute bucket index
        Node n = data[hashValue];

        if (n == null) {
            // Bucket empty: nothing to remove.
            return;
        }

        if (n.value == key) {
            // If head node contains key, remove by pointing bucket to head.next.
            data[hashValue] = n.next; // delete head in O(1) time
            return;
        }

        // Traverse chain while keeping reference to current node. We check n.next for the target to allow easy removal.
        while(n.next != null) {
            if (n.next.value == key) {
                // Bypass the node to remove it from the chain: O(1) once node is found.
                n.next = n.next.next;
                break; // key found and removed; exit loop
            }
            n = n.next; // advance to next node
        }

    }

    public boolean contains(int key) {
        int hashValue = hash(key); // compute bucket index
        Node n = data[hashValue];

        // Traverse chain and check for key equality.
        while(n!=null){
            if (n.value == key){
                // Found key in chain.
                return true;
            }
            n = n.next; // move to next node
        }

        // Reached end of chain without finding key.
        return false;
    }

    private int hash(int key) {
        // Simple modulo-based hash. Note: if keys may be negative, you'd adjust to keep index non-negative.
        return key % 10000;
    }
}
