class Solution {
    private int func(int index, int buy, int arr[], int dp[][]) {
        if (index >= arr.length) return 0;
        if (dp[index][buy] != -1) return dp[index][buy];

        int profit = 0;
        if (buy == 1) {
            int take = -arr[index] + func(index + 1, 0, arr, dp);
            int nottake = func(index + 1, 1, arr, dp);
            profit = Math.max(take, nottake);
        } else {
            int sell = arr[index] + func(index + 2, 1, arr, dp);
            int nosell = func(index + 1, 0, arr, dp);
            profit = Math.max(sell, nosell);
        }
        return dp[index][buy] = profit;
    }
    public int maxProfit(int arr[]) {
        int n = arr.length ; 
        int dp[][] = new int[n+1][2];
        for(int row[] : dp){
            Arrays.fill(row , -1); 
        }
        return func(0 , 1 , arr , dp);
    }
}
