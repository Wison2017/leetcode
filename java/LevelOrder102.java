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
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     if(root == null)
    //         return result;
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.add(root);
    //     while(!queue.isEmpty()){
    //         int size = queue.size();
    //         List<Integer> list = new ArrayList<>();
    //         while(size > 0){
    //             TreeNode node = queue.poll();
    //             list.add(node.val);
    //             if(node.left != null) queue.add(node.left);
    //             if(node.right != null) queue.add(node.right);
    //             size--;
    //         }
    //         result.add(list);
    //     }
    //     return result;
    // }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return new ArrayList<>();
        DFS(root, 0, result);
        return result;
    }
    public void DFS(TreeNode node, int level, List<List<Integer>> result) {
        if(node == null)
            return;
        if(result.size() < level + 1)
            result.add(new ArrayList<>());
        result.get(level).add(node.val);
        if(node.left != null) DFS(node.left, level + 1, result);
        if(node.right != null) DFS(node.right, level + 1,result);
    }
}
