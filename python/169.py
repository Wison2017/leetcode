class Solution(object):
    # def majorityElement(self, nums):
    #     """
    #     :type nums: List[int]
    #     :rtype: int
    #     """
    #     return sorted(nums)[len(nums)/2]
    def majorityElement(self, nums):
        count = 0
        majority = 0
        for num in nums:
            if count == 0:
                majority = num
            if majority == num:
                count+=1
            else:
                count-=1
        return majority
