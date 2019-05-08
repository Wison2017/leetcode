class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        temp=s[0]
        ans = 1
        for char in s[1:]:
            if char in temp:
                i = temp.find(char)
                temp = temp[i+1:]
            temp+=char
            if len(temp) > ans:
                ans = len(temp)
        return ans
        