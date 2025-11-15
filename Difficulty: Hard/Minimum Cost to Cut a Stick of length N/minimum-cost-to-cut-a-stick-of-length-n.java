class Solution {
    public int func(int i , int j , int arr[] , int dp[][]){
        if(i > j) return 0; 
        if(dp[i][j] != -1) return dp[i][j] ;
        
        int min = Integer.MAX_VALUE; 
        for(int idx = i ; idx <= j ; idx ++){
            int cost = arr[j+1] - arr[i-1] + func(i , idx - 1 , arr , dp) 
            + func(idx + 1 , j , arr , dp); 
            min = Math.min(min , cost); 
        }
        return dp[i][j] = min ; 
    }
    public int minCutCost(int n, int[] cuts) {
        int m = cuts.length ; 
        int arr[] = new int[m + 2];
        arr[0] = 0 ; 
        arr[m+1] = n ; 
        for(int i = 0 ; i < m ; i++){
            arr[i+1] = cuts[i]; 
        }
        Arrays.sort(arr) ;
        int dp[][] = new int[m+2][m+2] ;
        for(int row[] : dp){
            Arrays.fill(row , -1); 
        }
        return func(1, m , arr , dp);
    }
}
