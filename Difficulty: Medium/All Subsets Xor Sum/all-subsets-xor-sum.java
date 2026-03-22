class Solution {
    int func(int idx , int xor , int arr[] , int dp[][]){
        if(idx == arr.length) return xor; 
        if(dp[idx][xor] != -1) return dp[idx][xor]; 
        
        int nottake = func(idx + 1 , xor , arr , dp); 
        int take = func(idx + 1 , xor ^ arr[idx] , arr , dp); 
        return dp[idx][xor ] = take + nottake; 
    }
    int subsetXORSum(int arr[]) {
        int n = arr.length ; 
        int total = 0 ; 
        int max = 0 ; 
        
        for(int num : arr){
            total += num ; 
        }
        int dp[][]=  new int[n + 1][total + 1]; 
        for(int row[] : dp){
            Arrays.fill(row , -1); 
        }
        
        return func(0 , 0 , arr , dp); 
    }
}