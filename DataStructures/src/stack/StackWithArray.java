package stack;

public class StackWithArray {
	public int top;
	int[] data;
	int size;

	public StackWithArray(int size) {
		this.size = size;
		this.data = new int[size];
		this.top = -1;
	}

	public int push(int data) {
		if (top < size) {
			this.data[++top] = data;
			return data;
		}else {
			return -1;
		}
		
	}

	public int pop() {
		if (top >= 0) {
			return data[top--];
		}else {
			return -1;
		}
	}

	public int peek() {
		if (top >= 0) {
			return data[top];
		}else {
			return -1;
		}
	}

}
