//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
class Solution {
    public int func(int index , int target , int arr[] , int dp[][]){
        if(index == 0){
            if(target % arr[0] == 0){
                return target / arr[0]; 
            }
            else return (int ) 1e9 ; 
        }
        if(dp[index][target] != -1) return dp[index][target]; 
        int notpick = func(index -1 , target , arr, dp);
        int pick = (int ) 1e9  ;
        if(arr[index] <= target){
            pick = 1 + func(index , target-arr[index] , arr, dp) ;
        }
        return dp[index][target] = Math.min(pick, notpick); 
    }
    public int minCoins(int coins[], int sum) {
        int n = coins.length ;
        int dp[][] = new int[n][sum+1];
        for(int row[] : dp){
            Arrays.fill(row, (int)1e9 );
        }
        // int res =  func(n-1 , sum , coins , dp); 
        // if(res >= (int ) 1e9 ) return -1;
        // return res; 
        
        // if(coins[0] <= sum) return dp[0][coins[0]] = 1;
        
        for(int i = 0; i <= sum ; i++){
            if(coins[0] > 0 && i % coins[0] == 0){
                dp[0][i] = i / coins[0] ; 
            }
        }
        
        for(int idx = 1 ; idx < n ;idx++){
            for(int tar = 0 ; tar <= sum ; tar++){
                int notpick = dp[idx-1][tar];
                int pick = (int)1e9 ;
                if(coins[idx] <= tar){
                    pick = 1 + dp[idx][tar - coins[idx]]; 
                }
                dp[idx][tar] = Math.min(pick , notpick ); 
            }
        }
        int res =  dp[n-1][sum] ; 
        if(res == (int) 1e9)return -1 ;
        return res; 
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minCoins(arr, k);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends