class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length < 2) {
            return 0;
        }
        if (k >= prices.length / 2) {
            return greedy(prices);
        }
        if (k == 1) {
            return one(prices);
        }
        //0次交易也算一种情况，所以至多2次交易，要存0，1，2三种情况
        k = k + 1;

        int[][][] mp = new int[prices.length][k][2];
        for (int i = 0; i < k; i++) {
            mp[0][i][1] = -prices[0];
        }
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < k; j++) {
                mp[i][j][0] = Math.max(mp[i - 1][j][0], mp[i - 1][j][1] + prices[i]);
                mp[i][j][1] = Math.max(mp[i - 1][j][1], mp[i - 1][j - 1][0] - prices[i]);
                max = Math.max(max, mp[i][j][0]);
            }
        }
        return max;
    }

    private int greedy(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    private int one(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }
}
