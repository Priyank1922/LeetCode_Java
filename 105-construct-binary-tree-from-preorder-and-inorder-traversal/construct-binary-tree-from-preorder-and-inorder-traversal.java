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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int inorderIndex = 0;

        for (int i = 1; i < preorder.length; i++) {

            int currentVal = preorder[i];
            TreeNode node = stack.peek();

            if (node.val != inorder[inorderIndex]) {

                node.left = new TreeNode(currentVal);
                stack.push(node.left);

            } else {

                while (!stack.isEmpty() &&
                       stack.peek().val == inorder[inorderIndex]) {

                    node = stack.pop();
                    inorderIndex++;
                }

                node.right = new TreeNode(currentVal);
                stack.push(node.right);
            }
        }

        return root;
    }
}