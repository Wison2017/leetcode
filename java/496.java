import java.util.Stack;

class Solution {
    private int[] helper(int[] nums) {
        int[] next_greater_element_array = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            next_greater_element_array[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return next_greater_element_array;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nums2_next_greater_element_array = helper(nums2);
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    ans[i] = nums2_next_greater_element_array[j];
                }
            }
        }

        return ans;
    }
}
