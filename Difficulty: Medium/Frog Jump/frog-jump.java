//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases
        String str = br.readLine();
        int t = Integer.parseInt(str.trim());

        // Process each test case
        while (t-- > 0) {
            // Read the next line containing the array elements
            str = br.readLine();
            String[] tokens = str.trim().split("\\s+");

            // Convert the input strings to integers and store in an array
            ArrayList<Integer> list = new ArrayList<>();
            for (String token : tokens) {
                if (!token.isEmpty()) { // Ensure that the token is not empty
                    list.add(Integer.parseInt(token));
                }
            }

            // Convert ArrayList to int[] for processing
            int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

            // Create an instance of Solution and compute the minimum energy
            Solution ob = new Solution();
            int result = ob.minCost(arr);

            // Output the result followed by a tilde as per the original C++ code
            System.out.println(result);
            System.out.println("~");
        }
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    int func(int height[] , int index , int[] dp){
        if(index == 0) return 0; 
        if(index == 1) {
            return Math.abs(height[1] - height[0]); 
        }
        if(dp[index] != -1) return dp[index]; 
        int left = func(height, index-1 , dp) + Math.abs(height[index] - height[index-1]);
        int right = Integer.MAX_VALUE;
        if(index > 1){
            right = func(height , index-2 , dp) + Math.abs(height[index] - height[index-2]);
        } 
        dp[index] = Math.min(left , right); 
        return dp[index]; 
    }
    int minCost(int[] height) {
        int n = height.length ; 
        int dp[] = new int[n+1]; 
        for(int i = 0 ; i < n ; i++){
            dp[i] = -1;  
        }
        return func(height , n-1 , dp); 
    }
}

//{ Driver Code Starts.

// } Driver Code Ends