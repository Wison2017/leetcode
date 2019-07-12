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
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    // public int maxDepth(TreeNode root) {
    //     if(root == null)
    //         return 0;
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     int level = 0;
    //     queue.add(root);
    //     while(!queue.isEmpty()){
    //         int length = queue.size();
    //         level++;
    //         for (int i = 0; i < length; i++){
    //             TreeNode node = queue.poll();
    //             if(node.left != null) queue.add(node.left);
    //             if(node.right != null) queue.add(node.right);
    //         }
    //     }
    //     return level;
    // }
}
