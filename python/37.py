class Solution:
    n = 3
    N = 9
    rows = [set()for i in range(9)]
    cols = [set()for i in range(9)]
    box = [set() for i in range(9)]
    find = False
    board = None

    def placeNumber(self, num, row, col):
        index_of_box = (int)(row/3)*3 + (int)(col/3)
        self.board[row][col] = str(num)
        self.rows[row].add(num)
        self.cols[col].add(num)
        self.box[index_of_box].add(num)

    def removeNumber(self, num, row, col):
        index_of_box = (int)(row/3)*3 + (int)(col/3)
        self.rows[row].remove(num)
        self.cols[col].remove(num)
        self.box[index_of_box].remove(num)
        self.board[row][col] = '.'

    def isValid(self, num, row, col):
        index_of_box = (int)(row/3)*3 + (int)(col/3)
        if num in self.rows[row]: return False
        if num in self.cols[col]: return False
        if num in self.box[index_of_box]: return False
        return True

    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.board = board
        for row in range(self.N):
            for col in range(self.N):
                if self.board[row][col] is not '.':
                    num = (int)(self.board[row][col])
                    self.placeNumber(num, row, col)
        self.DFS(0, 0)

    def DFS(self, row, col):
        if row == self.N - 1 and col == self.N:
            self.find = True
        elif col == self.N:
            self.DFS(row + 1, 0)
        elif self.board[row][col] == '.':
            for num in range(1, 10):
                if self.isValid(num, row, col):
                    self.placeNumber(num, row, col)
                    self.DFS(row, col + 1)
                    if not self.find: self.removeNumber(num, row, col)
        else:
            self.DFS(row, col + 1)

