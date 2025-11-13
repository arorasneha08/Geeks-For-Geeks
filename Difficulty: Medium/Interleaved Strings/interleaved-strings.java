class Solution {
	public boolean isInterleave(String a,String b,String c){
        if (a.length() + b.length() != c.length()) {
            return false;
        }

        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int[] arr:dp) Arrays.fill(arr, -1);
        return combination(dp, a,b,c, 0, 0, 0) == 1 ? true : false;
	}

    private int combination(int[][] dp, String a, String b, String c, int ai, int bi, int ci) {
        if(ci == c.length()) return 1;
        if(dp[ai][bi] != -1) return dp[ai][bi];
        int take = 0;
        if(ai < a.length() && a.charAt(ai) == c.charAt(ci))
            take = combination(dp, a,b, c, ai+1, bi, ci+1);
        if(take == 0 && bi < b.length() && b.charAt(bi) == c.charAt(ci))
            take = combination(dp, a,b, c, ai, bi+1, ci+1);
        
        return dp[ai][bi] = take;
    }
}