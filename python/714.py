class Solution:
    # def maxProfit(self, prices: List[int], fee: int) -> int:
    #     if prices is None or len(prices == 0):
    #         return 0
    #     dp = [[0, 0] for _ in range(len(prices))]
    #     for i in range(len(prices)):
    #         dp[i][1] = -prices[0] - fee
    #     for i in range(1, len(prices)):
    #         dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
    #         dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee)
    #     return dp[len(prices) - 1][0]
    def maxProfit(self, prices: List[int], fee: int) -> int:
        if prices is None or len(prices) == 0:
            return 0
        dp_i_0 = 0
        dp_i_1 = -prices[0] - fee
        for i in range(1, len(prices)):
            temp = dp_i_0
            dp_i_0 = max(dp_i_0, dp_i_1 + prices[i])
            dp_i_1 = max(dp_i_1, temp - prices[i] - fee)
        return dp_i_0
