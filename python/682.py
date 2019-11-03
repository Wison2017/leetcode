class Solution:
    def calPoints(self, ops: List[str]) -> int:
        stack = []
        for str in ops:
            if str == "+":
                new_point = stack[-1] + stack[-2]
                stack.append(new_point)
            elif str == "D":
                new_point = stack[-1] * 2
                stack.append(new_point)
            elif str == 'C':
                stack.pop()
            else:
                stack.append(int(str))
        sum = 0
        for num in stack:
            sum += num
        return sum

