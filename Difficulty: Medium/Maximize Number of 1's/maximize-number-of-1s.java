//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];

            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int m = Integer.parseInt(br.readLine().trim());
            int ans = new Solution().maxOnes(arr, m);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // k is the maximum number of zeros allowed to flip
    public int maxOnes(int arr[], int k) {
        int n = arr.length ; 
        int maxLen = 0 ;
        int zeros = 0 ; 
        int left = 0 ; 
        
        for(int right = 0 ; right < n ; right ++){
            if(arr[right] == 0 ){
                zeros ++ ; 
            }
            while(zeros > k){
                if(arr[left] == 0) zeros -- ; 
                left ++ ; 
            }
            maxLen = Math.max(maxLen , right - left + 1) ; 
        }
        return maxLen ; 
    }
}