package src.tree;

import java.util.Arrays;

/*
 LeetCode 105: Construct Binary Tree from Preorder and Inorder Traversal
 https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 Pattern/Technique: Recursion / Divide and Conquer (construct tree from traversal arrays)

 Complexity (this implementation):
  - Time: O(n^2) worst-case. Each recursive call scans the inorder array to find the root (O(n))
    and Arrays.copyOfRange copies subarrays (O(k)). In degenerate/skewed trees this yields O(n^2).
  - Space: O(n^2) because of creating new subarrays at every recursion level. Recursion stack uses O(n).
  - Optimized note: Use a hashmap (value -> index in inorder) and pass index ranges to avoid copying arrays,
    achieving O(n) time and O(n) space (excluding recursion stack).
*/

public class ConstructBinaryTreeFromInorderPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // number of elements in preorder and inorder arrays
        int P = preorder.length;
        int I = inorder.length;
        // base case: if either array is empty, there is no subtree
        if (P <= 0 || I <= 0){
            return null;
        }

        // index of root in inorder
        int mid = -1;

        // root value is the first element in preorder traversal
        TreeNode root = new TreeNode(preorder[0]);

        // find the root index in inorder (linear scan) - O(n) per call
        for (int i = 0 ; i < I; i++){
            if (inorder[i] == preorder[0]){
                mid = i;
                break;
            }
        }

        // left subtree: inorder[0..mid-1], preorder[1..mid]
        // Arrays.copyOfRange performs array copying: O(k) where k is length of the slice
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, mid+1);

        // recursively construct the left subtree (divide and conquer)
        root.left = buildTree(leftPreOrder,leftInorder);

        // right subtree: inorder[mid+1..end], preorder[mid+1..end]
        int[] rightInorder = Arrays.copyOfRange(inorder, mid+1, I);
        int[] rightPreOrder = Arrays.copyOfRange(preorder, mid+1, P);

        // recursively construct the right subtree
        root.right = buildTree(rightPreOrder,rightInorder);
        // return the constructed subtree rooted at 'root'
        return root;

    }
}