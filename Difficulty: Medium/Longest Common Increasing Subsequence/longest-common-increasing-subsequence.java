class Solution {
    int LCIS(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[] dp = new int[m];
    
        for (int i = 0; i < n; i++) {
            int currentMax = 0;
            for (int j = 0; j < m; j++) {
                if (a[i] == b[j]) {
                    dp[j] = Math.max(dp[j], currentMax + 1);
                } else if (a[i] > b[j]) {
                    currentMax = Math.max(currentMax, dp[j]);
                }
            }
        }
    
        int maxLCIS = 0;
        for (int len : dp) maxLCIS = Math.max(maxLCIS, len);
        return maxLCIS;
    }
}