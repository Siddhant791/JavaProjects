package queue;

public class QueueWithArray {
	int[] array;
	int rear = -1;
	int size;

	public QueueWithArray(int n) {
		this.array = new int[n];
		this.size = n;
	}

	public boolean isEmpty() {
		return rear == -1;
	}

	public void add(int value) {
		if (rear == size - 1) {
			return;
		}
		rear++;
		array[rear] = value;
	}

	public int remove() {
		if (isEmpty()) {
			return -1;
		}
		int front = array[0];
		for (int i = 0; i < rear + 1; i++) {
			array[i] = array[i + 1];
		}
		rear--;
		return front;
	}

	public int peek() {
		if (isEmpty()) {
			return -1;
		}
		return array[0];
	}

}
