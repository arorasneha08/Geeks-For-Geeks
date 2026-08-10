class Solution {
    public int maxTask(int[] h, int[] l) {
        int [][] dp = new int[h.length][2];
        for(int [] arr : dp)
            Arrays.fill(arr, -1);    
        return helper(0, 0, h, l, dp);
    }

    private int helper(int ind, int prev, int [] h, int [] l, int [][] dp) {
        if(ind >= h.length)
            return 0;

        if(dp[ind][prev] != -1) return dp[ind][prev];

        int maxi = 0;
        if(prev == 0)
            maxi = h[ind] + helper(ind+1, 1, h, l, dp);

        maxi = Math.max(maxi, l[ind] + helper(ind+1, 1, h, l, dp));
        maxi = Math.max(maxi, helper(ind+1, 0, h, l, dp));

        return dp[ind][prev] = maxi;
    }
}