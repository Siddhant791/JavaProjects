package src.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    List<Integer> output = new ArrayList<>();

     public List<Integer> postorderTraversalIterative(TreeNode root) {
         if (root == null ){
             return new ArrayList<>();
         }
         Stack<TreeNode> stack = new Stack<>();
         List<Integer> result = new ArrayList<>();

         stack.add(root);

         TreeNode curr = root;

         while(!stack.isEmpty()){
             if (curr != null){
                 result.add(curr.val);
                 stack.add(curr);
                 curr = curr.right;
             }else {
                 curr = stack.pop();
                 curr = curr.left;
             }
         }

         Collections.reverse(result);

         return result;
     }

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        if (root == null ){
            return output;
        }

        postorderTraversalRecursive(root.left);
        postorderTraversalRecursive(root.right);
        output.add(root.val);
        return output;
    }
}
