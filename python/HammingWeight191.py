class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        # helper = 1
        # sum = 0
        # for i in range(32):
        #     if n & helper != 0:
        #         sum += 1
        #     helper <<= 1
        # return sum
        sum = 0
        while n != 0:
            n = n & (n - 1)
            sum += 1
        return sum
