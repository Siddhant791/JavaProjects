package queue;

public class CircularQueueWithArray {
	int front = -1,rear = -1;
	int[] array;
	int size;

	public CircularQueueWithArray(int n) {
		array = new int[n];
		size = n;
	}

	public boolean isEmpty() {
		return front == -1 && rear == -1;
	}

	public boolean isFull() {
		return front == (rear + 1) % size;
	}

	public void add(int value) {
		if (isFull()) {
			return;
		}
		if (isEmpty()) {
			front += 1;
		}
		rear = (rear + 1) % size;
		array[rear] = value;

	}

	public int remove() {
		if (isEmpty()) {
			return -1;
		}
		int out = array[front];
		array[front] = 0;
		if (front == rear) {
			front = -1;
			rear = -1;
		} else {
			front = (front + 1) % size;
		}
		return out;
	}

	public int peek() {
		if (isEmpty()) {
			return -1;
		}
		return array[front];

	}
}
