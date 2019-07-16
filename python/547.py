class UnionFind:
    def __init__(self, M):
        length = len(M)
        self.count = length
        self.root = [i for i in range(length)]
        self.deep = [0 for _ in range(length)]

    def find(self, i):
        if self.root[i] != i:
            self.root[i] = self.find(self.root[i])
        return self.root[i]

    def union(self, i, j):
        root_i = self.find(i)
        root_j = self.find(j)
        if root_j != root_i:
            if self.deep[root_i] > self.deep[root_j]:
                self.root[root_j] = root_i
            elif self.deep[root_i] < self.deep[root_j]:
                self.root[root_i] = root_j
            else:
                self.root[root_j] = root_i
                self.deep[root_i] += 1
            self.count -= 1


class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        if M is None or len(M) == 0:
            return 0
        uf = UnionFind(M)
        row = len(M)
        col = len(M[0])
        for x in range(row):
            for y in range(x + 1, col):
                if M[x][y] == 1:
                    uf.union(x, y)
        return uf.count