package tree;

public class BinaryTreeWithoutNode implements BinaryTree {
	private int value;
	private BinaryTreeWithoutNode right;
	private BinaryTreeWithoutNode left;

	public BinaryTreeWithoutNode(int value) {
		this.value = value;
	}

	public void insert(int val) {
		if (val <= value) {
			if (left == null) {
				left = new BinaryTreeWithoutNode(val);
			} else {
				left.insert(val);
			}
		} else {
			if (right == null) {
				right = new BinaryTreeWithoutNode(val);
			} else {
				right.insert(val);
			}
		}
	}

	public boolean contain(int val) {
		if (this.value == val) {
			return true;
		}
		if (val <= value) {
			if (left == null) {
				return false;
			} else {
				return left.contain(val);
			}
		} else {
			if (right == null) {
				return false;
			} else {
				return right.contain(val);
			}
		}
	}

	public void printPreOrderTraversal() {
		System.out.println(value);
		if (left != null) {
			left.printPreOrderTraversal();
		}
		if (right != null) {
			right.printPreOrderTraversal();
		}
	}

	public void inOrderTraversal() {
		if (left != null) {
			left.inOrderTraversal();
		}
		System.out.println(value);
		if (right != null) {
			right.inOrderTraversal();
		}
	}

	public void postOrderTraversal() {
		if (left != null) {
			left.postOrderTraversal();
		}
		if (right != null) {
			right.postOrderTraversal();
		}
		System.out.println(value);
	}

}
