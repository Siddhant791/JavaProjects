package src.tree;


public class MaximumDepthOfBinaryTree {

    static class MyTreeNode {
        int val;
        MyTreeNode left;
        MyTreeNode right;

        MyTreeNode(int x) {
            val = x;
        }
    }
    
    public int maxDepth(MyTreeNode root) {
        if (root == null){
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
