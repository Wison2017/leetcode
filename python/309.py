class Solution:
    # def maxProfit(self, prices: List[int]) -> int:
    #     if prices is None or len(prices) == 0:
    #         return 0
    #     dp = [[0, 0] for _ in range(len(prices))]
    #     for i in range(len(prices)):
    #         dp[i][1] = -prices[0]
    #     for i in range(1, len(prices)):
    #         dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
    #         if i == 1:
    #             dp[i][1] = max(dp[i - 1][1], -prices[i])
    #         else:
    #             dp[i][1] = max(dp[i - 1][1], dp[i - 2][0] - prices[i])
    #     return dp[len(prices) - 1][0]
    def maxProfit(self, prices: List[int]) -> int:
        if prices is None or len(prices) == 0:
            return 0
        dp_i_0 = 0
        dp_i_1 = -prices[0]
        dp_pre_0 = 0
        for i in range(1, len(prices)):
            temp = dp_i_0
            dp_i_0 = max(dp_i_0, dp_i_1 + prices[i])
            dp_i_1 = max(dp_i_1, dp_pre_0 - prices[i])
            dp_pre_0 = temp
        return dp_i_0