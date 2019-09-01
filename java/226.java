/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        inverse(root);
        return root;
    }

    public void inverse(TreeNode root) {
        if (root == null)
            return;
        else if (root.left == null && root.right == null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode temp = left;
        root.left = right;
        root.right = left;
        inverse(root.left);
        inverse(root.right);
    }
}