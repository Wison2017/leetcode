class Solution {
//    public int maxProfit(int[] prices) {
//        if (prices == null || prices.length == 0)
//            return 0;
//        int[][] DP = new int[prices.length][2];
//        DP[0][0] = 0; DP[0][1] = -prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            DP[i][0] = Math.max(DP[i-1][0], DP[i-1][1] + prices[i]);
//            if (i == 1)
//                DP[i][1] = Math.max(DP[i-1][1], -prices[i]);
//            else
//                DP[i][1] = Math.max(DP[i-1][1], DP[i-2][0] - prices[i]);
//        }
//        return DP[prices.length-1][0];
//    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int dp_i_0 = 0; int dp_i_1 = -prices[0];
        int dp_pre2_0 = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre2_0 - prices[i]);
            dp_pre2_0 = temp;
        }
        return dp_i_0;
    }
}