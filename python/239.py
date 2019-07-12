class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if len(nums) <= 1:
            return nums
        dqueue = []
        for i in range(k):
            while dqueue and dqueue[-1] < nums[i]:
                dqueue = dqueue[:-1]
            dqueue.append(nums[i])
        result = []
        result.append(dqueue[0])
        for j in range(k, len(nums)):
            if nums[j - k] == dqueue[0]:
                dqueue = dqueue[1:]
            while dqueue and dqueue[-1] < nums[j]:
                dqueue = dqueue[:-1]
            dqueue.append(nums[j])
            result.append(dqueue[0])
        return result
            
        
