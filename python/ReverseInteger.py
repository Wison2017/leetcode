class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        result = 0
        if (x > (2**31 -1)) or (x < (-2**31)):
            return result
        if (x < 0):
            temp = str(-1*x)
            reverse = temp[::-1]
            result = int(reverse) * -1
        if (x > 0):
            temp = str(x)
            reverse = temp[::-1]
            result = int(reverse)
        if (result > (2**31 -1) or (result < (-2**31))):
            return 0
        return result
