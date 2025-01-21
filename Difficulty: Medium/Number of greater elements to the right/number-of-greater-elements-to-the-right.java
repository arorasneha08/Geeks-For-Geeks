//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      int q = sc.nextInt();
      int ind[]=new int[q]; 
      for(int i=0;i<q;i++) ind[i]=sc.nextInt();
      Solution obj = new Solution();
      int ans[] = obj.count_NGEs(n,a,q,ind);
      for(int e : ans)
      System.out.print(e+" ");
      System.out.println();
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int countNGE(int arr[] , int elem , int index , int n){
        int count = 0 ;
        Stack<Integer> st = new Stack<>();
        for(int i = n-1 ; i >= index ; i--){
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            st.push(arr[i]); 
            if(arr[i] > elem) {
                count ++ ; 
            }
        }
        return count; 
    }
  public static int[] count_NGEs(int n, int arr[], int queries, int indices[]) {
      int res[] = new int[indices.length] ; 
    for(int i = 0 ; i< indices.length ; i++){
        int index = indices[i]; 
        int elem = arr[indices[i]]; 
        res[i] = countNGE(arr, elem, index, n);
    }
    return res ; 
  }
}
     