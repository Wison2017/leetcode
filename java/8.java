class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0)
            return 0;
        int flag = 1;
        int sum = 0;
        int start = 0;
        int end = str.length();
        if(str.charAt(0) == '-') {
            flag = -1;
            start = 1;
        }
        if(str.charAt(0) == '+') {
            start = 1;
        }
        for (int i = start; i < end; i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                int num = str.charAt(i) - '0';
                if ((Integer.MAX_VALUE - num) / 10 < sum) {
                    return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else {
                    sum = sum * 10 + num;
                }
            } else {
                break;
            }
        }
        return sum * flag;
    }
}