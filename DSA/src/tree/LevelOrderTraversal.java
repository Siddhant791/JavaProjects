package src.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> out = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){

            List<TreeNode> temp = new ArrayList<>();
            List<Integer> insideList = new ArrayList<>();

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null){
                    temp.add(node.left);
                }
                if (node.right != null){
                    temp.add(node.right);
                }

                insideList.add(node.val);
            }

            if (!insideList.isEmpty()){
                out.add(new ArrayList<Integer>(insideList));
            }

            for (TreeNode node : temp){
                queue.add(node);
            }

        }

        return out;
    }
}
