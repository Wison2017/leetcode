class Solution:
    def totalNQueens(self, n: int) -> int:
        self.sum = 0
        self.DFS([], [], [], n)
        return self.sum

    def DFS(self, xy_sub, xy_sum, board, n):
        x = len(board)
        if x == n:
            self.sum = self.sum + 1
            return
        for y in range(0, n):
            if y not in board and x+y not in xy_sum and x-y not in xy_sub:
                self.DFS(xy_sub + [x-y], xy_sum + [x+y], board+[y], n)
