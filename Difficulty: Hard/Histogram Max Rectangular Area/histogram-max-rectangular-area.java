//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
class Solution {
    public static int[] pse(int arr[] , int n){
        Stack<Integer> st = new Stack<>();
        int res[] = new int[n] ; 
        for(int i = 0 ; i<n ; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i); 
        }
        return res ; 
    } 
    public static int[] nse(int arr[] , int n){
        Stack<Integer> st = new Stack<>();
        int res[] = new int[n] ; 
        for(int i = n-1 ; i >= 0 ; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i); 
        }
        return res ; 
    } 
    public static int getMaxArea(int arr[]) {
        int n = arr.length ; 
        int pse[] = pse(arr, n); 
        int nse[] = nse(arr, n); 
        int maxArea = 0 ; 
        for(int i = 0 ; i<n ; i++){
            int width = nse[i] - pse[i] - 1; 
            maxArea = Math.max(maxArea, width * arr[i]) ; 
        }
        return maxArea ; 
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
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
            Solution obj = new Solution();
            int res = obj.getMaxArea(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends