//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
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
            ArrayList<Integer> res = new Solution().maxOfSubarrays(arr, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length ; 
        int ans[] = new int[n-k+1]; 
        int index = 0 ; 
        Deque<Integer> q = new LinkedList<>();
        for(int i = 0; i < n ; i++){
            if(!q.isEmpty() && q.peek() == i-k){
                q.pollFirst();
            }
            while(!q.isEmpty() && arr[i] > arr[q.peekLast()]){
                q.pollLast();    
            }
            q.offer(i) ;
            if(i >= k-1){
                ans[index++] = arr[q.peek()]; 
            }
        }
        for(int i = 0; i < ans.length; i++){
            res.add(ans[i]); 
        }
        return res; 
    }
}