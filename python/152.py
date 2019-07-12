class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if nums is None: return 0
        result, cur_max, cur_min = nums[0], nums[0], nums[0]
        for i in range(1, len(nums)):
            cur_max, cur_min = cur_max * nums[i], cur_min * nums[i]
            cur_max, cur_min = max(cur_max, cur_min, nums[i]), min(cur_max, cur_min, nums[i])
            if cur_max > result: result = cur_max
        return result

