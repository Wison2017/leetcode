class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        if len(nums) < 3:
            return []
        nums.sort()
        res = set()
        for index, a in enumerate(nums[:-2]):
            if index >= 1 and nums[index-1] == a:
                continue
            dict = {}
            for b in nums[index+1:]:
                if b not in dict:
                    dict[-a-b] = 1
                else:
                    res.add((a, -a-b, b))
        return list(map(list, res))

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        if len(nums) < 3:
            return []
        nums.sort()
        res = set()
        for index, a in enumerate(nums[:-2]):
            if index >= 1 and nums[index-1] == a:
                continue
            left = index + 1
            right = len(nums) - 1
            while left < right:
                sum = a + nums[left] + nums[right]
                if sum < 0:
                    left += 1
                elif sum > 0:
                    right -= 1
                else:
                    res.add((a, nums[left], nums[right]))
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    left += 1
                    right -= 1
        return list(map(list, res))



