package tree;

import javax.swing.tree.TreeNode;

public class FindLowestCommonAncestor {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // edge condition to handle if both nodes are parent children in same hierarchy
        if (p.val == root.val){
            return p;
        }
        if (q.val == root.val){
            return q;
        }

        if (p.val > root.val && q.val < root.val){
            return root;
        }
        if (q.val > root.val && p.val < root.val){
            return root;
        }

        if (q.val > root.val){
            // traverse right subtree
            return lowestCommonAncestor(root.right, p, q);
        }else {
            // traverse right subtree
            return lowestCommonAncestor(root.left, p , q);
        }
    }

}
