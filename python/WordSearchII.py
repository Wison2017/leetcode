import collections


class Solution:

    END_OF_WORD = '*'
    directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        if board is None or board[0] is None:
            return []
        if words is None:
            return []

        self.result = set()
        self.words = words
        root = collections.defaultdict()

        for word in words:
            node = root
            for char in word:
                node = node.setdefault(char, collections.defaultdict())
            node[self.END_OF_WORD] = self.END_OF_WORD

        row = len(board)
        col = len(board[0])
        flag = [[0 for _ in range(col)] for _ in range(row)]
        for x in range(row):
            for y in range(col):
                if self.words is None:
                    break
                if board[x][y] in root:
                    self._dfs(board, flag, x, y, '', root)
        return list(self.result)

    def _dfs(self, board, flag, cur_x, cur_y, cur_word, root):
        cur_word += board[cur_x][cur_y]
        cur_dict = root[board[cur_x][cur_y]]
        flag[cur_x][cur_y] = 1
        if self.END_OF_WORD in cur_dict:
            self.result.add(cur_word)
        for direction in self.directions:
            x = cur_x + direction[0]
            y = cur_y + direction[1]
            if 0 <= x < len(board) and 0 <= y < len(board[0]) and flag[x][y] != 1 and board[x][y] in cur_dict:
                self._dfs(board, flag, x, y, cur_word, cur_dict)
        flag[cur_x][cur_y] = 0
