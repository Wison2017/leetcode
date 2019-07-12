class Solution:
    def totalNQueens(self, n: int) -> int:
        self.sum = 0
        self.n = n
        self.DFS(0, 0, 0, 0)
        return self.sum

    def DFS(self, row, col, pie, na):
        if row >= self.n:
            self.sum += 1
            return
        bits = (~(col | pie | na)) & ((1 << self.n) - 1)
        while bits > 0:
            bit = bits & -bits
            self.DFS(row + 1, col | bit, (pie | bit) << 1, (na | bit) >> 1)
            bits &= bits - 1
