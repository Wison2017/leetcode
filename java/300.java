class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] DP = new int[nums.length];
        int result = 1;
        for (int i = 0; i < DP.length; i++) {
            DP[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
            if (DP[i] > result) result = DP[i];
        }
        return result;
    }
}
