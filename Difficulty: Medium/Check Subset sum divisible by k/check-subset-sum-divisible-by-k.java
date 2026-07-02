class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        // code here
        boolean[] dp = new boolean[k];
        dp[0] = false; 
        
        for (int num : arr) {
            boolean[] newDp = dp.clone();
            for (int j = 0; j < k; j++) {
                if (dp[j]) {
                    newDp[(j + num) % k] = true;
                }
            }
            newDp[num % k] = true;
            dp = newDp;
        }
        
        return dp[0]; 
    }
}