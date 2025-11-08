package src.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    List<Integer> output = new ArrayList<>();

    public List<Integer> preorderTraversalIterative(TreeNode root) {

        if (root == null){
            return new ArrayList<>();
        }

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> output = new ArrayList<>();

        stack.add(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }

        return output;
    }



    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        if (root == null){
            return output;
        }
        output.add(root.val);
        preorderTraversalRecursive(root.left);
        preorderTraversalRecursive(root.right);
        return output;
    }

}
