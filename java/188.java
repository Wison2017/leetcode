class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        if (prices.length / 2 <= k) {
            int max_profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1])
                    max_profit += (prices[i] - prices[i-1]);
            }
            return max_profit;
        }
        else {
            int[][][] DP = new int[prices.length][k+1][2];
            for (int i = 0; i < prices.length; i++) {
                for (int j = 1; j <= k; j++) {
                    DP[i][j][1] = -prices[0];
                }
            }
            for (int i = 1; i < prices.length; i++) {
                for (int j = 1; j <= k; j++) {
                    DP[i][j][0] = Math.max(DP[i-1][j][0], DP[i-1][j][1] + prices[i]);
                    DP[i][j][1] = Math.max(DP[i-1][j][1], DP[i-1][j-1][0] - prices[i]);
                }
            }
            return DP[prices.length - 1][k][0];
        }
    }
}
