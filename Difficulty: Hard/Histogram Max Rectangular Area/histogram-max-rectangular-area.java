//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
class Solution {
    public static int getMaxArea(int arr[]) {
        int n = arr.length ;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0 ; 
        for(int i = 0 ; i< n ; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                int height = arr[st.pop()]; 
                int width = (st.isEmpty()) ? i : i - st.peek()-1 ; 
                int area = height * width ;
                maxArea = Math.max(area , maxArea); 
            }
            st.push(i); 
        }
        while(!st.isEmpty()){
            int height = arr[st.pop()];
            int width = (st.isEmpty()) ? n : n - st.peek()-1 ; 
            int area = height * width ;
            maxArea = Math.max(maxArea , area); 
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