// User function Template for Java

class Solution {
    private static int func(int i , int j , int arr[] , int dp[][]){
        if(i > j) return 0 ; 
        if(dp[i][j] != -1) return dp[i][j]; 
        
        int max = Integer.MIN_VALUE ; 
        for(int k = i ; k <= j ; k++){
            int cost = arr[i-1] * arr[k] * arr[j+1] + func(i , k-1, arr, dp) + func(k+1 , j , arr, dp); 
            max = Math.max(max , cost); 
        }
        return dp[i][j] = max ; 
    }
    public static int maxSkill(int[] arr) {
        int n = arr.length ; 
        int dp[][] = new int[n+1][n+1]; 
        List<Integer> list = new ArrayList<>(); 
        list.add(1); 
        for(int num : arr){
            list.add(num); 
        }
        list.add(1); 
        int a[] = new int[n+2]; 
        for(int i = 0 ; i < list.size() ; i++){
            a[i] = list.get(i); 
        }
        for(int row[] : dp){
            Arrays.fill(row , -1) ; 
        }
        return func(1 , n , a , dp); 
    }
}
