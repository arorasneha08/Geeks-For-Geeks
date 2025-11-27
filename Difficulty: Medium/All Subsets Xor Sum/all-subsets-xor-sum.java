class Solution {
    Integer[][] dp;

    int func(int idx, int xor, int[] arr) {
        if (idx == arr.length) return xor;

        if (dp[idx][xor] != null) return dp[idx][xor];

        int pick = func(idx + 1, xor ^ arr[idx], arr);
        int notpick = func(idx + 1, xor, arr);

        return dp[idx][xor] = pick + notpick;
    }

    int subsetXORSum(int[] arr) {
        dp = new Integer[arr.length][2048]; 
        return func(0, 0, arr);
    }
}
