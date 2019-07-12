class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int length = nums.length;
        // int[] result = new int[2];
        // for(int i = 0; i < length - 1; i++){
        //     for(int j = i + 1; j < length; j++){
        //         if (nums[i] + nums[j] == target){
        //             result[0] = i;
        //             result[1] = j;
        //             break;
        //         }
        //     }
        // }
        // return result;
        HashMap map = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) == null)
                map.put(nums[i], i);
            else{
                result[0] = (int)map.get(target - nums[i]);
                result[1] = i;
                break;
            }                 
        }
        return result;
    }
}
