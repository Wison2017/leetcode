class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        row = len(word1)
        col = len(word2)
        DP = [[0 for _ in range(col+1)]for _ in range(row+1)]
        for x in range(row+1):
            DP[x][0] = x
        for y in range(col+1):
            DP[0][y] = y
        for x in range(1, row + 1):
            for y in range(1, col + 1):
                if word1[x-1] == word2[y-1]:
                    DP[x][y] = DP[x-1][y-1]
                else:
                    DP[x][y] = min(DP[x-1][y-1] + 1, DP[x-1][y] + 1, DP[x][y-1] + 1)
        return DP[row][col]
