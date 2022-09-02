package tree;

public interface BinaryTree {
	public void insert(int value);
	public void printPreOrderTraversal();
	public void printBFS();
	public int totalNumberOfNodes();
	public Node deletNodeFromTree(int value);
}
