# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        if not root.left: return 1 + self.minDepth(root.right)
        if not root.right: return 1 + self.minDepth(root.left)
        
        left = self.minDepth(root.left)
        right = self.minDepth(root.right)
        return min(left, right) + 1
