class Solution:
    def mySqrt(self, x: int) -> int:    
        left = 0
        right = x // 2 + 1
        while left < right:
            mid = left + (right - left + 1) // 2
            square = mid * mid
            if square == x:
                return mid
            if square > x:
                right = mid -1
            else:
                left = mid
        return left
