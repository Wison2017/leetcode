class Solution:
    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    def exist(self, board, word: str) -> bool:
        if board is None:
            return False
        row_max = len(board)
        col_max = len(board[0])
        flag = [[0 for i in range(col_max)] for j in range(row_max)]
        for x in range(row_max):
            for y in range(col_max):
                if word[0] == board[x][y]:
                    flag[x][y] = 1
                    if self._dfs(board, x, y, word[1:], flag, row_max, col_max):
                        return True
                    else:
                        flag[x][y] = 0
        return False

    def _dfs(self, board, origin_x, origin_y, word, flag, row_max, col_max):
        if len(word) == 0:
            return True
        for d in self.directions:
            x = origin_x + d[0]
            y = origin_y + d[1]
            if 0 <= x < row_max and 0 <= y < col_max and board[x][y] == word[0] and flag[x][y] == 0:
                flag[x][y] = 1
                if self._dfs(board, x, y, word[1:], flag, row_max, col_max):
                    return True
                flag[x][y] = 0
        return False

