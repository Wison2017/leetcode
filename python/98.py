# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # def isValidBST(self, root: TreeNode) -> bool:
    #     def helper(node, lower=float('-inf'), upper=float('inf')):
    #         if not node:
    #             return True
    #         if node.val <= lower or node.val >= upper:
    #             return False
    #         return helper(node.left, lower, node.val) and helper(node.right, node.val, upper)
    #     return helper(root)
    def isValidBST(self, root: TreeNode) -> bool:
        stack, pre = [], float('-inf')
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if root.val <= pre:
                return False
            pre = root.val
            root = root.right
        return True
