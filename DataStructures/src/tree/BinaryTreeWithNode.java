package tree;

public class BinaryTreeWithNode implements BinaryTree{
	private Node root;

	public BinaryTreeWithNode(int val) {
		root = new Node(val);
	}

	public void insert(int value) {
		insertInto(value, root);
	}

	public void printPreOrderTraversal() {
		preOrderTraversal(root);
	}

	public void insertInto(int val, Node node) {
		if (node.value >= val) {
			if (node.left == null) {
				node.left = new Node(val);
			} else {
				insertInto(val, node.left);
			}
		} else {
			if (node.right == null) {
				node.right = new Node(val);
			} else {
				insertInto(val, node.right);
			}
		}
	}

	public void preOrderTraversal(Node node) {
		System.out.println(node.value);
		if (node.left != null) {
			preOrderTraversal(node.left);
		}
		if (node.right != null) {
			preOrderTraversal(node.right);
		}
	}
}
