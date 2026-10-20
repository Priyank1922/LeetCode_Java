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
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }
    private void inOrder(TreeNode root){
        if(root == null) return ;

        inOrder(root.left);

        if(prev != null) minDiff = Math.min(minDiff , root.val - prev.val);

        prev = root;

        inOrder(root.right);
    }
}