class Solution {
    // public double myPow(double x, int n) {
    //     if(n == 0)
    //         return 1;
    //     long N = n;
    //     if (N < 0)
    //         N = -N;
    //     double result = 1;
    //     double weight = x;
    //     for (long i = N; i > 0; i/=2) {
    //         if (i % 2 == 1)
    //             result *= weight;
    //         weight *= weight;
    //     }
    //     return n < 0 ? 1/result : result;
    // }
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        long N = n;
        if (n < 0){
            N = -N;
            x = 1/x;
        }
        return helper(x, N);
    }
    public double helper(double x, long n){
        if (n == 1)
            return x;
        long half = n / 2;
        double halfResult = helper(x, half);
        if (n % 2 == 1)
            return halfResult * halfResult * x;
        else
            return halfResult * halfResult;
    }
}
