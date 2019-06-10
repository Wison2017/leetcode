class Solution {
    // public int maxProfit(int[] prices) {
    //     int maxProfit = 0;
    //     int low = 0;
    //     int high = 0;
    //     int i = 0;
    //     while(i < prices.length - 1){
    //         while(i < prices.length - 1 && prices[i] >= prices[i + 1])
    //             i++;
    //         low = prices[i];
    //         while(i < prices.length - 1 && prices[i] <= prices[i + 1])
    //             i++;
    //         high = prices[i];
    //         maxProfit += high - low;
    //     }
    //     return maxProfit;
    // }
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++){
            if (prices[i + 1] > prices[i])
                maxProfit += prices[i + 1] - prices[i];
        }
        return maxProfit;
    }
}
