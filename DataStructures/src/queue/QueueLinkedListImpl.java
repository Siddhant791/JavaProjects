package queue;

public class QueueLinkedListImpl {
	public Node head;
	public Node tail;

	static class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public boolean isEmpty() {
		return head == null & tail == null;
	}

	public void add(int data) {
		if (head == null) {
			head = new Node(data);
			tail = head;
		} else {
			Node newNode = new Node(data);
			tail.next = newNode;
			tail = newNode;
		}
	}

	public int remove() {
		if (isEmpty()) { // case - 1 for empty queue
			return -1;
		}
		int out = head.data;
		if (tail == head) { // case-2 for single element
			tail = null;
		}
		head = head.next;
		return out;
	}
	
	public int peek() {
		if(isEmpty()) {
			return -1;
		}
		return head.data;
		
	}
}
