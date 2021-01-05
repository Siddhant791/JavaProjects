package linkedList;

public class LinkedList<E> {
	
	public Node<E> head;
	public int size=0;
	
	public void insert(E data) {
		Node<E> temp1 = head;
		Node<E> temp = new Node(data);
		if(this.head==null) {
			head=temp;
			size++;
			return;
		}
		while(temp1.next!=null) {
			temp1=temp1.next;
		}
		temp1.next=temp;
		size++;
	}
	
	public void deleteByElement(E data) {
		Node temp = head;
		if(head==null) {
			return;
		}
		if(temp.data==data) {
			if(temp.next==null) {
				head=null;
				size--;
			}else {
				head=head.next;
				size--;
			}
		}
		
		while(temp.next!=null) {
			if(temp.next.data==data) {
				if(temp.next.next==null){
					temp.next=null;
					size--;
					break;
				}else {
					temp.next=temp.next.next;
					size--;
				} 
			}
			temp=temp.next;
		}
		
	}
	
	
	public E get(int index) throws Exception {
		
		if(head==null) {
			throw new Exception("Linked list is empty");
		}
		if(index>=size) {
			throw new Exception("Index is greater than size of linked list");
		}
		Node<E> temp = head;
		for(int i=0;i<index;i++) {
			temp=temp.next;
		}
		return temp.data;
	}
	
	public void printAllElements() {
		Node<E> temp=head;
		if(head==null) {
			System.out.println("Linked list is empty");
			return;
		}
		
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	
	public E removeLastElement() throws Exception {
		if(head==null) {
			throw new Exception("linked list is empty");
		}
		if(head.next==null) {
			Node<E> returnNode = head;
			clearList();
			return returnNode.data;
		}
		Node<E> temp=head;
		while(temp.next.next!=null) {
			temp=temp.next;
		}
		Node<E> returnNode = temp.next;
		temp.next=null;
		return returnNode.data;
	}
	
	public boolean isEmpty() {
		return head==null?true:false;
	}
	
	public void clearList() {
		head=null;
	}
	
	public E getLastElement() throws Exception {
		Node<E> temp=head;
		if(head==null) {
			throw new Exception("Linked List is empty");
		}
		if(head.next==null) {
			return head.data;
		}
		while(temp.next!=null) {
			temp=temp.next;
		}
		return temp.data;
	}
	
}
