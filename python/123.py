class Solution:
    # def maxProfit(self, prices: List[int]) -> int:
    #     if prices is None or len(prices) == 0:
    #         return 0
    #     dp = [[[0, 0] for _ in range(3)] for _ in range(len(prices))]
    #     for i in range(len(prices)):
    #         for j in range(3):
    #             dp[i][j][1] = -prices[0]
    #     for i in range(1, len(prices)):
    #         for j in range(1, 3):
    #             dp[i][j][0] = max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i])
    #             dp[i][j][1] = max(dp[i - 1][j][1], dp[i - 1][j-1][0] - prices[i])
    #     return dp[len(prices) - 1][2][0]

    def maxProfit(self, prices: List[int]) -> int:
        if prices is None or len(prices) == 0:
            return 0
        dp = [[0, 0] for _ in range(3)]
        for i in range(3):
            dp[i][1] = -prices[0]
        for i in range(1, len(prices)):
            for j in range(1, 3):
                dp[j][0] = max(dp[j][0], dp[j][1] + prices[i])
                dp[j][1] = max(dp[j][1], dp[j - 1][0] - prices[i])
        return dp[2][0]
