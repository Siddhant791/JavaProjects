package tree;

public class FindingSubTree {
	public boolean containSubTree(Node root, Node search) {
		if (search == null) {
			return true;
		}
		if (root == null) {
			return false;
		}
		if (root.value == search.value) {
			isIdentical(root, search);
		}
		return containSubTree(root.left, search) && containSubTree(root.right, search);
	}

	public boolean isIdentical(Node root, Node search) {
		if (search == null && root == null) {
			return true;
		}
		if (search == null || root == null) {
			return false;
		}
		if (root.value == search.value) {
			return isIdentical(root.left, search.right) && isIdentical(root.left, search.right);
		}
		return false;
	}

}
