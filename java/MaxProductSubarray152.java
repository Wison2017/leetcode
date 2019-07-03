class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null) return 0;
        int result, cur_max , cur_min;
        result = cur_max = cur_min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = Math.max(cur_max * nums[i], cur_min * nums[i]);
            max = Math.max(max, nums[i]);
            int min = Math.min(cur_max * nums[i], cur_min * nums[i]);
            min = Math.min(min, nums[i]);
            cur_max = max;
            cur_min = min;
            
            if (cur_max > result) result = cur_max;
        }
        return result;
    }
}
