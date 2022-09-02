package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeWithNode implements BinaryTree {
	public Node root;
	private Queue<Node> queue = new LinkedList<Node>();

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

	public void printBFS() {
		queue.add(root);
		while (!this.queue.isEmpty()) {
			Node currentNode = queue.remove();
			System.out.println(currentNode.value);
			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}

	}

	@Override
	public int totalNumberOfNodes() {
		// TODO Auto-generated method stub
		return countWrapper(root);
	}

	public int countWrapper(Node node) {
		int outleft = 0;
		int outRight = 0;
		if (node == null) {
			return 0;
		}
		outleft += countWrapper(node.left);
		outRight += countWrapper(node.right);

		return outleft + outRight + 1;
	}

	@Override
	public Node deletNodeFromTree(int value) {
		return deleteNode(root, value);
	}

	public Node deleteNode(Node node, int val) {
		if (node == null) {
			return null;
		}
		if (node.value == val) {
			return check(node, val);
		}
		if (node.value > val) {
			node.left = deleteNode(node.left, val);
		} else {
			node.right = deleteNode(node.right, val);
		}
		return node;
	}

	public Node check(Node node, int val) {
		if (node.left == null && node.right == null) {
			return null;
		}
		if (node.left == null) {
			return node.right;
		}
		if (node.right == null) {
			return node.left;
		}
		Node successor = inOrderSuccessor(node.right);
		node.value = successor.value;
		node.right = deleteNode(node.right, node.value);
		return node;
	}

	public Node inOrderSuccessor(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

}
