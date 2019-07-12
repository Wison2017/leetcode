class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2: return n
        ways = [0, 1, 2]
        i = 3
        while i <= n:
            ways.append(ways[i - 1] + ways[i - 2])
            i += 1
        return ways[n]
