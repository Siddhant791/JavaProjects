package mainPackage;

import tree.BinaryTree;
import tree.BinaryTreeWithNode;
import tree.BinaryTreeWithoutNode;

public class MainClass {

	public static void main(String[] args) throws Exception {
		BinaryTree bt = new BinaryTreeWithNode(8);
		int[] arr = {1,7,9,4,2,6};
		for(int i=0;i<arr.length;i++) {
			bt.insert(arr[i]);
		}
		//System.out.println(bt.contain(5));
		bt.printPreOrderTraversal();
	}

}
