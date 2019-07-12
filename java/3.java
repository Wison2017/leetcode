class Solution {
    // public int lengthOfLongestSubstring(String s) {
    //     int length = s.length();
    //     int ans = 0;
    //     for (int i = 0; i < length; i++){
    //         int j = length - 1;
    //         if (j - i + 1 < ans)
    //             break;
    //         for (; j >= i; j--){
    //             if (j - i + 1 < ans){
    //                 break;
    //             }
    //             if (allUnique(s, i, j))
    //                 ans = Math.max(ans, j - i + 1);
    //         }
    //     }
    //     return ans;
    // }
    // public boolean allUnique(String s, int start, int end){
    //     Set<Character> set = new HashSet<>();
    //     for (int i = start; i <= end; i++){
    //         Character ch = s.charAt(i);
    //         if (set.contains(ch))
    //             return false;
    //         set.add(ch);
    //     }
    //     return true;
    // }
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}