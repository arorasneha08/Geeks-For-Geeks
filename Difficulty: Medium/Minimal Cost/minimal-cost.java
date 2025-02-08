//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int getMin(int arr[] , int k , int index , int[] dp){
        if(index == 0) return 0 ; 
        int min = Integer.MAX_VALUE; 
        if(dp[index] != -1) return dp[index] ; 
        for(int i = 1 ; i<= k ; i++){
            if(index - i >= 0 ){
                int jumps = getMin(arr, k , index-i, dp) + Math.abs(arr[index] - arr[index-i]);
                
                min = Math.min(jumps, min) ; 
                dp[index] = min ; 
            }
        }
        return dp[index] ; 
    }
    public int minimizeCost(int k, int arr[]) {
        int n = arr.length ; 
        int dp[] = new int[n+1] ; 
        Arrays.fill(dp , -1) ; 
        return getMin(arr , k, n-1 , dp) ; 
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
            int res = obj.minimizeCost(k, arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends