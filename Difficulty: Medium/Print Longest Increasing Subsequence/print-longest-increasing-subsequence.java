//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.longestIncreasingSubsequence(N, arr);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int nums[]) {
        // int n = nums.length ;
        int dp[] = new int[n]; 
        int hash[] = new int[n] ; 
        Arrays.fill(dp , 1); 
        int max = 1 ; 
        int lastIdx = 0 ; 
        for(int i = 0 ; i < n ; i++){
            hash[i] = i ; 
            for(int prev = 0 ; prev < i ; prev++){
                if(nums[prev] < nums[i] && 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev]; 
                    hash[i] = prev ; 
                }
            }
            if(dp[i] > max){
                max = dp[i];
                lastIdx = i ; 
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[lastIdx]); 
        while(hash[lastIdx] != lastIdx){
            lastIdx = hash[lastIdx]; 
            list.add(nums[lastIdx]); 
        }
        Collections.reverse(list);
        return list ; 
    }
}
