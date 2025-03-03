//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends


class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        ArrayList<Integer> res = new ArrayList<>() ;
        TreeMap<Integer , Integer> mpp = new TreeMap<>();
        int left = 0 , right = 0 ;
        int maxLen = 0 ; 
        int startIdx = 0 ; 
        
        int n = arr.length; 
        while(right < n){
            mpp.put(arr[right] , mpp.getOrDefault(arr[right], 0)+1); 
            
            while(mpp.lastKey() - mpp.firstKey() > x){
                mpp.put(arr[left] , mpp.get(arr[left])-1); 
                if(mpp.get(arr[left]) == 0){
                    mpp.remove(arr[left]); 
                }
                left ++ ; 
            }
            
            if(right - left + 1 > maxLen){
                maxLen = right - left + 1 ; 
                startIdx = left;
            }
            right ++ ; 
        }
        for(int i = startIdx ; i < startIdx + maxLen ; i++){
            res.add(arr[i]); 
        }
        return res; 
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

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.longestSubarray(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends