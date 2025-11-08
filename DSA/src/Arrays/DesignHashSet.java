package src.Arrays;

public class DesignHashSet {

}

class Node {
    public int value;
    public Node next;

    public Node(int value){
        this.value = value;
    }
}

class MyHashSet {

    Node[] data;

    public MyHashSet() {
        data = new Node[10000];
    }

    public void add(int key) {
        int hashValue = hash(key);
        Node n = data[hashValue];

        if(n == null) {
            data[hashValue] = new Node(key);
            return;
        }

        while (n.next != null) {
            if (n.value == key){
                return;
            }
            n = n.next;
        }

        if (n.value == key){
            return;
        }

        n.next = new Node(key);
    }

    public void remove(int key) {

        int hashValue = hash(key);
        Node n = data[hashValue];

        if (n == null) {
            return;
        }

        if (n.value == key) {
            data[hashValue] = n.next;
            return;
        }

        while(n.next != null) {
            if (n.next.value == key) {
                n.next = n.next.next;
                break;
            }
            n = n.next;
        }

    }

    public boolean contains(int key) {
        int hashValue = hash(key);
        Node n = data[hashValue];

        while(n!=null){
            if (n.value == key){
                return true;
            }
            n = n.next;
        }

        return false;
    }

    private int hash(int key) {
        return key % 10000;
    }
}
