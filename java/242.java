import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    
//    public boolean isAnagram(String s, String t) {
//        HashMap<Character, Integer> map1 = new HashMap();
//        HashMap<Character, Integer> map2 = new HashMap();
//        for(int i = 0; i < s.length(); i++){
//            if (map1.containsKey(s.charAt(i)))
//                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
//            else
//                map1.put(s.charAt(i), 1);
//        }
//        for(int i = 0; i < t.length(); i++){
//            if (map2.containsKey(t.charAt(i))) {
//                map2.put(t.charAt(i), map2.get(t.charAt(i)) + 1);
//            }
//            else
//                map2.put(t.charAt(i), 1);
//        }
//        return map1.equals(map2);
//    }
    public boolean isAnagram(String s, String t) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            map1[index] = map1[index] + 1;
        }
        for (int j = 0; j < t.length(); j++){
            int index = t.charAt(j) - 'a';
            map2[index] = map2[index] + 1;
        }
        for(int k = 0; k < map1.length; k++){
            if (map1[k] != map2[k])
                return false;
        }
        return true;
    }

}
