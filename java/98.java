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
    // public boolean isValid(TreeNode node, Integer lower, Integer upper){
    //     if(node == null) return true;
    //     if(lower != null && node.val <= lower) return false;
    //     if(upper != null && node.val >= upper) return false;
    //     return isValid(node.left, lower, node.val) && isValid(node.right, node.val, upper);
    // }
    // public boolean isValidBST(TreeNode root) {
    //     return isValid(root, null, null);
    // }
    
    public boolean isValidBST(TreeNode root){
        if(root == null) return true;
            Stack<TreeNode> stack = new Stack();
            double pre = -Double.MAX_VALUE;
            while (!stack.empty() || root != null){
                while(root != null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if(root.val <= pre)
                    return false;
                pre = root.val;
                root = root.right;
            }
            return true;
    }
}
