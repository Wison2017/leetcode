class Solution {
//    public int maxProfit(int[] prices) {
//        if (prices == null || prices.length == 0)
//            return 0;
//        int time = 2;
//        int[][][] DP = new int[prices.length][time + 1][2];
//        DP[0][1][1] = -prices[0];
//        DP[0][2][1] = -prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            for (int k = 1; k <= time; k++) {
//                DP[i][k][0] = Math.max(DP[i-1][k][0], DP[i-1][k][1] + prices[i]);
//                DP[i][k][1] = Math.max(DP[i-1][k][1], DP[i-1][k-1][0] - prices[i]);
//            }
//        }
//        return DP[prices.length - 1][time][0];
//    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int time = 2;
        int[][] DP = new int[time+1][2];
        DP[0][0] = 0;
        DP[0][1] = -prices[0];
        DP[1][1] = -prices[0];
        DP[2][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int k = time; k >= 1; k--) {
                DP[k][0] = Math.max(DP[k][0], DP[k][1] + prices[i]);
                DP[k][1] = Math.max(DP[k][1], DP[k-1][0] - prices[i]);
            }
        }
        return DP[time][0];
    }
}
