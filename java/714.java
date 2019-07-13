class Solution {
//    public int maxProfit(int[] prices, int fee) {
//        if (prices == null || prices.length == 0)
//            return 0;
//        int[][] DP = new int[prices.length][2];
//        DP[0][0] = 0; DP[0][1] = -prices[0] - fee;
//        for (int i = 1; i < prices.length; i++) {
//            DP[i][0] = Math.max(DP[i-1][0], DP[i-1][1] + prices[i]);
//            DP[i][1] = Math.max(DP[i-1][1], DP[i-1][0] - prices[i] - fee);
//        }
//        return DP[prices.length - 1][0];
//    }
    public int maxProfit(int[] prices, int fee) {
         if (prices == null || prices.length == 0)
             return 0;
         int dp_i_0 = 0; int dp_i_1 = -prices[0]-fee;
         for (int i = 1; i < prices.length; i++) {
             int temp = dp_i_0;
             dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
             dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
         }
         return dp_i_0;
    }
}