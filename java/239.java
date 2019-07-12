class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= 1)
            return nums;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] > dq.peekLast())
                dq.removeLast();
            dq.add(nums[i]);
        }
        int[] result = new int[nums.length - k + 1];
        int index = 0;
         result[index++] = dq.peek();
        for (int j = k; j < nums.length; j++) {
            if (dq.peek() == nums[j - k])
                dq.removeFirst();
            while (!dq.isEmpty() && nums[j] > dq.peekLast())
                dq.removeLast();
            dq.add(nums[j]);
            result[index++] = dq.peek();
        }
        return result;
    }
}
