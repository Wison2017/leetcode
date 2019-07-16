class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        if prices is None or len(prices) == 0:
            return 0
        if len(prices)/2 <= k:
            sum = 0
            for i in range(1, len(prices)):
                if prices[i] > prices[i - 1]:
                    sum += prices[i] - prices[i - 1]
            return sum
        dp = [[[0, 0] for _ in range(k+1)] for _ in range(len(prices))]
        for i in range(len(prices)):
            for j in range(k+1):
                dp[i][j][1] = -prices[0]
        for i in range(1, len(prices)):
            for j in range(1, k + 1):
                dp[i][j][0] = max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i])
                dp[i][j][1] = max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i])
        return dp[len(prices) - 1][k][0]