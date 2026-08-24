class Solution {
    public int prefixStrings(int n) {
        long dp[]=new long[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int l=0,r=i-1;
            while(l<=i-1){
                dp[i]=(dp[i]+(dp[l]*dp[r]))%1000000007;
                l++;
                r--;
            }
        }
        return (int)dp[n]%1000000007;
    }
}