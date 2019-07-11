class Solution {
    public int coinChange(int[] coins, int amount) {
        int MAX = amount + 1;
        List< Integer> dp = new ArrayList<>(Collections.nCopies(amount + 1, MAX));
        dp.set(0, 0);
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int temp = Math.min(dp.get(i), dp.get(i - coins[j]) + 1);
                    dp.set(i, temp);
                }
            }
        }
        return dp.get(amount) > amount ? -1 : dp.get(amount);
    }
}
