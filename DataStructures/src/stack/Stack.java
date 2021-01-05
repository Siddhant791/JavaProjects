package stack;

import linkedList.LinkedList;

public class Stack<E> {
	LinkedList<E> linkList = new LinkedList<E>();
	
	public void push(E data) {
		linkList.insert(data);
	}
	
	public void pop() throws Exception {
		linkList.removeLastElement();
	}
	
	public E peek() throws Exception{
		E returnOutput=null;
		try {
			returnOutput = linkList.getLastElement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.addSuppressed(new Exception("Stack is empty"));
			throw new Exception("Stack is empty");
		}
		return returnOutput;
	}
}
