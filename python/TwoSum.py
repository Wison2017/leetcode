class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict = {}
        for i in range(len(nums)):
            if dict.get(target - nums[i], None) == None:
                dict[nums[i]] = i
            else:
                return [dict[target - nums[i]], i]
