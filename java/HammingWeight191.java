public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        int helper = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & helper) == 1)
                sum++;
            helper <<= 1;
        }
        return sum;
    }
    //solution2
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            n = n & (n - 1);
            sum++;
        }
        return sum;
    }
}
