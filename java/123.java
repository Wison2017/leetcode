class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int length = prices.length;
        int result = 0;
        int[][][] MP = new int[length][3][2];
        MP[0][1][1] = -prices[0];
        MP[0][2][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            for (int k = 2; k >= 1; k--) {
                MP[i][k][0] = Math.max(MP[i - 1][k][0], MP[i - 1][k][1] + prices[i]);
                MP[i][k][1] = Math.max(MP[i - 1][k][1], MP[i - 1][k - 1][0] - prices[i]);
                int max = Math.max(MP[i][k][0], MP[i][k][1]);
                if (max > result) result = max;
            }
        }
        return result;
    }
}
