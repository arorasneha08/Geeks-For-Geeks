//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
// User function Template for Java

class Solution {

    public int minDifference(int nums[]) {
        int n = nums.length ; 
        int totalSum = 0 ; 
        for(int i = 0 ; i < n ; i++){
            totalSum += nums[i]; 
        }
        int target = totalSum; 
        boolean dp[][] = new boolean[n][target+1];
        for(int i = 0 ; i < n ; i++){
            dp[i][0] = true ; 
        }
        if(nums[0] <= target) {
            dp[0][nums[0]] = true;  
        }
        for(int idx = 1 ; idx < n ; idx ++){
            for(int tar = 1 ; tar <= target ; tar++){
                boolean nottake = dp[idx - 1][tar];
                boolean take = false; 
                if(nums[idx] <= tar){
                    take = dp[idx-1][tar - nums[idx]]; 
                }
                dp[idx][tar] = take || nottake ; 
            }
        }
        int mini = Integer.MAX_VALUE ; 
        for(int s1 = 0 ; s1 <= totalSum/2 ; s1 ++){
            if(dp[n-1][s1] == true){
                mini = Math.min(mini , Math.abs((totalSum - s1)- s1)); 
            }
        }
        return mini ; 
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

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

            // int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.minDifference(arr);

            System.out.print(ans);

            System.out.println(); // New line after printing the results
        }
    }
}

// } Driver Code Ends