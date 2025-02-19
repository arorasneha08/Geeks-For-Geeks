//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    Solution ob = new Solution();
		    long[] res = ob.nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        ot.print(res[i] + " ");
		    ot.println();
		}
        ot.close();
	}
}



// } Driver Code Ends


// User Function Template for JAVA

class Solution{
    public static long[] nextLargerElement(long[] arr, int n) { 
        Stack<Long> st = new Stack<>();
        long res[] = new long[n]; 
        
        for(int i = 0 ; i<n ; i++){
            res[i] = -1; 
        }
        
        for(int i = 2 * n - 1 ; i >= 0 ; i--){
            while(!st.isEmpty() && st.peek() <= arr[i % n]){
                st.pop(); 
            }
            if(!st.isEmpty()){
                res[i% n] = st.peek(); 
            }
            st.push(arr[i % n]); 
        }
        return res ; 
    } 
}