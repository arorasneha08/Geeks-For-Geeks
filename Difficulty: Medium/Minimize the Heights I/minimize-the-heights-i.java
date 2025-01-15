//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String input = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());

            // Split the input line into integers and store them in the array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the getMinDiff method
            int res = ob.getMinDiff(arr, k);

            // Print the result
            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int getMinDiff(int[] arr, int k) {
        int n = arr.length;
         Arrays.sort(arr); 
         int res = arr[n - 1] - arr[0];
         
         for(int i = 1; i < arr.length; i++){
             int minH = Math.min(arr[0] + k, arr[i] - k);
             int maxH = Math.max(arr[n - 1] - k, arr[i - 1] + k);
             res = Math.min( res, maxH - minH);
         }
         return res;
    }
}  