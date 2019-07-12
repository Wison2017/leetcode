import collections
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # def levelOrder(self, root: TreeNode) -> List[List[int]]:
    #     if not root:
    #         return []
    #     queue = collections.deque()
    #     result = []
    #     queue.append(root)
    #     while queue:
    #         length = len(queue)
    #         list = []
    #         for _ in range(0, length):
    #             node = queue.popleft()
    #             list.append(node.val)
    #             if node.left:
    #                 queue.append(node.left)
    #             if node.right:
    #                 queue.append(node.right)
    #         result.append(list)
    #     return result
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root: return []
        self.result = []
        self._dfs(root, 0)
        return self.result
    
    def _dfs(self, node, level):
        if not node:
            return
        if len(self.result) < level + 1:
            self.result.append([])
        self.result[level].append(node.val)
        self._dfs(node.left, level+1)
        self._dfs(node.right, level+1)
