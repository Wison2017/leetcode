class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack stack = new Stack();
        int length = s.length();
        for (int i = 0; i < length; i++){
            if (!map.containsKey(s.charAt(i)))
                stack.push(s.charAt(i));
            else if(stack.empty() || map.get(s.charAt(i)) != stack.pop())
                return false;
        }
        return stack.empty();
    }
}
