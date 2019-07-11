class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        DP = [ 1 for _ in range(len(nums))]
        result = 1
        for i in range(1, len(nums)):
            for j in range(0, i):
                if nums[i] > nums[j]:
                    DP[i] = max(DP[i], DP[j] + 1)
            result = max(result, DP[i])
        return result
