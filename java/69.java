class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x / 2 + 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            long square = (long)mid * mid;
            if (square == x)
                return mid;
            if (square > x)
                right = mid - 1;
            else
                left = mid;
        }
        return left;
    }
}
