# class Solution:
# by DFS
#     direction = [[1, 0], [-1, 0], [0, -1], [0, 1]]
#
#     def numIslands(self, grid: List[List[str]]) -> int:
#         if grid is None or len(grid) == 0:
#             return 0
#         row = len(grid)
#         col = len(grid[0])
#         count = 0
#         for x in range(row):
#             for y in range(col):
#                 if grid[x][y] == '1':
#                     count += 1
#                     self._dfs(grid, x, y)
#         return count
#
#     def _dfs(self, grid, cur_row, cur_col):
#         row_max = len(grid)
#         col_max = len(grid[0])
#         if (cur_row < 0 or cur_row >= row_max or cur_col < 0 or cur_col >= col_max or grid[cur_row][cur_col] == '0'):
#             return
#         grid[cur_row][cur_col] = '0'
#         for d in self.direction:
#             row = cur_row + d[0]
#             col = cur_col + d[1]
#             self._dfs(grid, row, col)
class UnionFind:
    def __init__(self, grid):
        row = len(grid)
        col = len(grid[0])
        self.root = [0 for _ in range(row * col)]
        self.deep = [0 for _ in range(row * col)]
        self.count = 0
        for x in range(row):
            for y in range(col):
                if grid[x][y] == '1':
                    self.root[x * col + y] = x * col + y
                    self.deep[x * col + y] = 1
                    self.count += 1

    def find(self, i):
        if self.root[i] != i:
            self.root[i] = self.find(self.root[i])
        return self.root[i]

    def union(self, i, j):
        root_i = self.find(i)
        root_j = self.find(j)
        if root_i != root_j:
            if self.deep[root_i] > self.deep[root_j]:
                self.root[root_j] = root_i
            elif self.deep[root_i] < self.deep[root_j]:
                self.root[root_i] = root_j
            else:
                self.root[root_i] = root_j
                self.deep[root_j] += 1
            self.count -= 1


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid) == 0:
            return 0
        uf = UnionFind(grid)
        row = len(grid)
        col = len(grid[0])
        for x in range(row):
            for y in range(col):
                if grid[x][y] == '1':
                    if x + 1 < row and grid[x + 1][y] == '1':
                        uf.union(x * col + y, (x + 1) * col + y)
                    if y + 1 < col and grid[x][y + 1] == '1':
                        uf.union(x * col + y, x * col + y + 1)
        return uf.count
