class Solution:
    # def myPow(self, x: float, n: int) -> float:
    #     if n == 0:
    #         return 1
    #     if n < 0:
    #         n = -n
    #         x = 1/x
    #     result = 1
    #     weight = x
    #     while n != 0:
    #         i = n & 1
    #         if i == 1:
    #             result = result * weight
    #         weight *= weight
    #         n >>= 1
    #     return result

    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n < 0:
            n = -n
            x = 1/x
        if n % 2 == 1:
            return x * self.myPow(x, n - 1)
        return self.myPow(x*x, n/2)