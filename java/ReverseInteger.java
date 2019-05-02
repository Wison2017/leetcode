class Solution {
    public int reverse(int x) {
        int current = 0;
        int result = 0;
        if(x > ((2<<30) - 1) || x < (2<<30))
            return result;
        while(true){
            current = x % 10;
            result += current;
            x = x / 10;
            if (x == 0)
                break;
            if (result > ((2<<30) - 1) / 10 || result < ((2<<30) / 10))
                return 0;
            result = result * 10;
        }
        return result;
    }
}
