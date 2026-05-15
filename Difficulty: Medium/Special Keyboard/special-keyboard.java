class Solution {
    public int optimalKeys(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            
            for (int j = 1; j <= i - 3; j++) {
                int pastes = i - j - 2;

                int current = dp[j] * (pastes + 1);

                dp[i] = Math.max(dp[i], current);
            }
        }

        return dp[n];
    }
}