//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countPartitions(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    int countPartitions(int[] arr, int d) {
        int n = arr.length; 
        int totalSum = 0 ;
        
        for(int i = 0; i < n ; i++){
            totalSum += arr[i]; 
        }
        int target = (totalSum - d )/ 2; 
        if(totalSum - d < 0 || (totalSum - d )% 2 != 0 ) return 0 ; 
        
        int dp[][] = new int[n][target+1];
        
        if(arr[0] == 0 ) dp[0][0] = 2 ;
        else dp[0][0] = 1 ; 
        if(arr[0] !=0 && arr[0] <= target) dp[0][arr[0]] = 1 ;
        
        
        for(int idx = 1 ; idx < n ; idx ++){
            for(int tar = 0 ; tar <= target ; tar++){
                int notpick = dp[idx-1][tar];
                int pick = 0; 
                if(arr[idx] <= tar){
                    pick = dp[idx-1][tar- arr[idx]]; 
                }
                dp[idx][tar] = pick + notpick ; 
            }
        }
        return dp[n-1][target] ; 
    }
}
