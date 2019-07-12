import java.util.HashMap;

class Solution {
    // public int majorityElement(int[] nums) {
    //     if(nums.length == 1)
    //         return nums[0];
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for (int i = 0; i < nums.length; i++){
    //         if(map.containsKey(nums[i])) {
    //             int value = map.get(nums[i]) + 1;
    //             if (value > nums.length / 2)
    //                 return nums[i];
    //             map.put(nums[i], value);
    //         }
    //         else
    //             map.put(nums[i], 1);
    //     }
    //     return 0;
    // }
		// public int majorityElement(int[] nums) {
		// int count = 1;
		// int maj = nums[0];
		// for (int i = 1; i < nums.length; i++) {
		// 	if (maj == nums[i])
		// 		count++;
		// 	else {
		// 		count--;
		// 		if (count == 0) {
		// 			maj = nums[i + 1];
		// 		}
		// 	}
		// }
		// return maj;
		// }
    public int majorityElement(int[] nums){
        int current = 0;
        int count = 0;
        for (Integer num : nums) {
            if (count == 0){
                current = num;
                count++;
                continue;
            }
            if (current != num)
                count--;
            else
                count++;
        }
        return current;
    }
}
