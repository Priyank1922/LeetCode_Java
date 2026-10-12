/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;

        return helper(
                inorder,
                postorder,
                0,
                len - 1,
                0,
                len - 1
        );
    }

    private TreeNode helper(int[] inorder,
                            int[] postorder,
                            int inStart,
                            int inEnd,
                            int postStart,
                            int postEnd) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }


        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        
        int rootIndex = inStart;

        while (rootIndex <= inEnd) {
            if (inorder[rootIndex] == rootVal) {
                break;
            }
            rootIndex++;
        }

        int leftSize = rootIndex - inStart;


        root.left = helper(
                inorder,
                postorder,
                inStart,
                rootIndex - 1,
                postStart,
                postStart + leftSize - 1
        );

        
        root.right = helper(
                inorder,
                postorder,
                rootIndex + 1,
                inEnd,
                postStart + leftSize,
                postEnd - 1
        );

        return root;
    }
}