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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root , "" , ans);
        return ans;
    }
    private void helper (TreeNode root , String path , List<String> ans){
        if(root == null) return ;

        if(path.length()== 0)  path = String.valueOf(root.val);
        else
        path = path +"->"+root.val;

        if(root.left == null && root.right == null){
            ans.add(path);
            return;
        }
        helper(root.left , path , ans);
        helper(root.right , path , ans);
    }
}