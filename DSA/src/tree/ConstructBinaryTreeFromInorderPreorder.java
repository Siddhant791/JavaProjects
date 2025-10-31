package src.tree;

import java.util.Arrays;

public class ConstructBinaryTreeFromInorderPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int P = preorder.length;
        int I = inorder.length;
        if (P <= 0 || I <= 0){
            return null;
        }

        int mid = -1;

        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 0 ; i < I; i++){
            if (inorder[i] == preorder[0]){
                mid = i;
                break;
            }
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, mid+1);

        root.left = buildTree(leftPreOrder,leftInorder);

        int[] rightInorder = Arrays.copyOfRange(inorder, mid+1, I);
        int[] rightPreOrder = Arrays.copyOfRange(preorder, mid+1, P);

        root.right = buildTree(rightPreOrder,rightInorder);
        return root;

    }
}
