class Solution:
    # def maxProfit(self, prices: List[int]) -> int:
    #     maxProfit = 0
    #     low = 0
    #     high = 0
    #     i = 0
    #     length = len(prices)
    #     while i < length - 1:
    #         while i < length - 1 and prices[i] >= prices[i+1]:
    #             i+=1
    #         low = prices[i]
    #         while i < length - 1 and prices[i] <= prices[i+1]:
    #             i+=1
    #         high = prices[i]
    #         maxProfit += high - low
    #     return maxProfit
    def maxProfit(self, prices: List[int]) -> int:
        maxProfit = 0
        for i in range(len(prices) - 1):
            if prices[i] < prices[i + 1]:
                maxProfit += prices[i + 1] - prices[i]
        return maxProfit
