class Solution:
    def minimumTotal(self, triangle) -> int:
        if triangle is None:
            return 0
        result = list(triangle[-1])
        for row in range(len(triangle) - 2, -1, -1):
            for col in range(0, len(triangle[row])):
                result[col] = triangle[row][col] + min(result[col], result[col + 1])
        return result[0]
