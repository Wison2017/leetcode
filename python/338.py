class Solution:
    def countBits(self, num: int) -> List[int]:
        count = [0]
        for i in range(1, num + 1):
            result = count[i & (i-1)] + 1
            count.append(result)
        return count
