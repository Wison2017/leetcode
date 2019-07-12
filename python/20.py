class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        map = {')': '(', ']': '[', '}': '{'}
        for char in s:
            if char not in map:
                stack.append(char)
            elif not stack or stack.pop() != map[char]:
                return False
        return not stack
