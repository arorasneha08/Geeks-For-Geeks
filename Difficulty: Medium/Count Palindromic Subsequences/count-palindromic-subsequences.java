//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();
            // System.out.println(str.length());
            Solution ob = new Solution();
            System.out.println(ob.countPS(str));
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*You are required to complete below method */

class Solution {
    int mod = (int)1e9+7 ;
    public int func(int i , int j , String s , int dp[][]){
        if(i > j) return 0; 
        if(i == j){
            return dp[i][j] = 1; 
        }
        if(dp[i][j] != -1)return dp[i][j]; 
        int count = 0 ; 
        if(s.charAt(i) == s.charAt(j)){
            count = (1 +  func(i+1 , j, s, dp) + func(i , j-1 , s, dp)) % mod ; 
        }
        else{
            count = (func(i, j-1 , s, dp) + func(i+1 , j, s, dp) - func(i+1, j-1, s, dp)) % mod; 
        }
        dp[i][j] = count; 
        return dp[i][j]; 
    }
    int countPS(String s) {
        int n = s.length();
        int dp[][] = new int[n][n+1] ; 
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i] , -1); 
        }
        return func(0 , n-1 , s, dp);
    }
}