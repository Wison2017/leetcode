class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                flag = true;
                break;
            }
        }
        if (flag == false)
            return 1;
        if (n == 1)
            return 2;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n)
                nums[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            if (a == n) {
                nums[0] = -(Math.nums[0]);
            } else {
                nums[a] = -(Math.nums[a]);
            }
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }

        if (nums[0] > 0)
            return n;

        return n + 1;
    }
}