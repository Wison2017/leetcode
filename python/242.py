class Solution:
    # def isAnagram(self, s: str, t: str) -> bool:
    #     dict1 = {}
    #     dict2 = {}
    #     for char in s:
    #         dict1[char] = dict1.get(char, 0) + 1
    #     for char in t:
    #         dict2[char] = dict2.get(char, 0) + 1
    #     return dict1 == dict2
    def isAnagram(self, s:str, t:str) -> bool:
        dict1 = [0]*26
        dict2 = [0]*26
        for char in s:
            index = ord(char) - ord('a')
            dict1[index] += 1
        for char in t:
            index = ord(char) - ord('a')
            dict2[index] += 1
        return dict1 == dict2
