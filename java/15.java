import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//        if (nums.length < 3)
//            return new ArrayList<>();
//        int nums_length = nums.length;
//        Arrays.sort(nums);
//        HashSet<List<Integer>> result = new HashSet<>();
//        for (int i = 0; i < nums_length -2; i++){
//            if (i > 0 && nums[i] == nums[i - 1])
//                continue;
//            int left = i + 1;
//            int right = nums_length - 1;
//            while (left < right) {
//                int sum = nums[i] + nums[left] + nums[right];
//                if (sum < 0)
//                    left += 1;
//                else if (sum > 0)
//                    right -= 1;
//                else {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(nums[i]); list.add(nums[left]); list.add(nums[right]);
//                    result.add(list);
//                    while(left < right && nums[left] == nums[left + 1])
//                        left++;
//                    while(left < right && nums[right] == nums[right - 1])
//                        right--;
//                    left++; right--;
//                }
//            }
//        }
//        List<List<Integer>> format_result = new ArrayList<>();
//        for(List<Integer> item : result){
//            format_result.add(item);
//        }
//        return format_result;
//    }
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return new ArrayList<>();
        HashSet<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            HashSet<Integer> temp = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++){
                if (!temp.contains(nums[j]))
                    temp.add(-(nums[i] + nums[j]));
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]); list.add(-nums[i]-nums[j]); list.add(nums[j]);
                    result.add(list);
                }
            }
        }
        List<List<Integer>> format_result = new ArrayList<>();
        for(List<Integer> item : result){
            format_result.add(item);
        }
        return format_result;
    }
}
