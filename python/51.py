class Solution:
    # def solveNQueens(self, n: int) -> List[List[str]]:
    #     def DFS(queens, xy_sum, xy_sub):
    #         x = len(queens)
    #         if x >= n:
    #             result.append(queens)
    #             return
    #         for y in range(0, n):
    #             if y not in queens and (x + y) not in xy_sum and (y - x) not in xy_sub:
    #                 DFS(queens + [y], xy_sum + [x + y], xy_sub + [y - x])
    #     result = []
    #     DFS(queens, [], [])
    #     return [["."*i + "Q" + "."*(n - i - 1) for i in queens]for queens in result]
    def solveNQueens(self, n: int):
        self.result = []
        self.xy_sum = []
        self.xy_sub = []
        self._DFS([], n)
        return self._generateResult(n)

    def _DFS(self, queens, n):
        x = len(queens)
        if x == n:
            self.result.append(queens)
            return
        for y in range(0, n):
            if y not in queens and (x + y) not in self.xy_sum and (y - x) not in self.xy_sub:
                self.xy_sum.append(x + y)
                self.xy_sub.append(y - x)

                self._DFS(queens + [y], n)

                self.xy_sum.remove(x + y)
                self.xy_sub.remove(y - x)

    def _generateResult(self, n):
        return [["."*i + "Q" + "."*(n - i - 1) for i in queens]for queens in self.result]

