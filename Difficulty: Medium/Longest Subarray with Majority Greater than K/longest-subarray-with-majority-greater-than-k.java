//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    static int longestSubarray(int[] arr, int k) {
        int n = arr.length; 
        int maxLen = 0 ; 
        HashMap<Integer , Integer> mpp = new HashMap<>(); 
        int diff[] = new int[n];
        for(int i= 0 ;  i < n ; i++){
            if(arr[i] > k) diff[i] = 1; 
            else diff[i] = -1; 
        }
        int prefSum = 0 ; 
        for(int i = 0 ; i < n ; i++){
            prefSum += diff[i];
            if(prefSum > 0){
                maxLen = i+1 ; 
            }
            else{
                if(mpp.containsKey(prefSum - 1)){
                    maxLen = Math.max(maxLen , i - mpp.get(prefSum-1)); 
                }
            }
            
            if(!mpp.containsKey(prefSum)){
                mpp.put(prefSum , i); 
            }
        }
        return maxLen ; 
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int n = tokens.length;
            int[] arr = new int[n];

            int i = 0;
            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr[i] = Integer.parseInt(token);
                i++;
            }

            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(new Solution().longestSubarray(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends