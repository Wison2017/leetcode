class Solution:
    def helper(self, nums):
        stack = []
        next_greater_element_array = [0 for i in range(len(nums))]
        for i in range(len(nums) - 1, -1, -1):
            while stack and stack[-1] <= nums[i]:
                stack.pop()
            next_greater_element = stack[-1] if stack else -1
            next_greater_element_array[i] = next_greater_element
            stack.append(nums[i])
        return next_greater_element_array

    def nextGreaterElement(self, nums1, nums2):
        nums2_next_greater_element_array = self.helper(nums2)
        ans = []
        for i in range(len(nums1)):
            for j in range(len(nums2)):
                if nums1[i] == nums2[j]:
                    ans.append(nums2_next_greater_element_array[j])
        return ans
