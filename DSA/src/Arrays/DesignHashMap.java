package src.Arrays;

public class DesignHashMap {

}


class NodeHashMap {
    public int key;
    public int value;
    public NodeHashMap next;

    public NodeHashMap(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {

    NodeHashMap[] map;

    public MyHashMap() {
        this.map = new NodeHashMap[1000000];
    }

    public void put(int key, int value) {
        int hashValue = hash(key);
        NodeHashMap node = map[hashValue];

        if ( node == null) {
            map[hashValue] = new NodeHashMap(key, value);
            return;
        }

        while(node.next != null) {
            if (node.key == key){
                node.value = value;
                return;
            }
            node = node.next;
        }

        if (node.key == key){
            node.value = value;
        }

        node.next = new NodeHashMap(key, value);
    }

    public int get(int key) {
        int hashValue = hash(key);
        NodeHashMap node = map[hashValue];
        if (node == null) {
            return -1;
        }

        while(node!=null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hashValue = hash(key);
        NodeHashMap node = map[hashValue];
        if (node == null) {
            return;
        }

        if (node.key == key) {
            map[hashValue] = node.next;
            return;
        }

        while (node.next != null) {
            if (node.next.key == key){
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }

    public int hash(int key){
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
