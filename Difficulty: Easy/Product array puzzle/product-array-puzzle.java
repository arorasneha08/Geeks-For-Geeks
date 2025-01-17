//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length ;
        int ans[] = new int[n] ; 
        int left = 1 , right = 1 ;
        for(int i = 0 ; i<n ; i++){
            ans[i] = 1 ; 
        }
        for(int i = 0 ; i<n ; i++){
            ans[i] = left ; 
            left = left * arr[i] ; 
        }
        for(int j = n-1 ; j>= 0 ; j--){
            ans[j] *= right ; 
            right = right * arr[j] ; 
        }
        return ans ;
    }
}
