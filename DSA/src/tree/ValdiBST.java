package src.tree;

public class ValdiBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root,  Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode node, long left, long right){
        if (node == null) {
            return true;
        }

        if (!(left < node.val && right > node.val)){
            return false;
        }

        return helper(node.left, left, node.val) && helper(node.right, node.val, right);
    }
}
