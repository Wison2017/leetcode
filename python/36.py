class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        def check(map, n):
            if n in map:
                return False
            map[n]=1
            return True
        rows = [{}for i in range(9)]
        cols = [{}for i in range(9)]
        box = [{}for i in range(9)]

        for x in range(9):
            for y in range(9):
                if not board[x][y] == '.':
                    index_of_box = (int)(x/3)*3 + (int)(y/3)
                    num = (int)(board[x][y])
                    if not check(rows[x], num): return False
                    if not check(cols[y], num): return False
                    if not check(box[index_of_box], num): return False
        return True
