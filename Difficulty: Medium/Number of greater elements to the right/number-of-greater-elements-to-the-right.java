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


// User function Template for Java

class Solution {
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        int n = arr.length ; 
        int vals[] = new int[n];
        int res[] = new int[queries] ;  
        for(int i = 0 ; i < n ; i++){
            int count = 0 ; 
            for(int j = i+1 ; j < n ; j++){
                if(arr[j] > arr[i]){
                    count ++ ; 
                }
            }
            vals[i] = count; 
        }
        for(int i = 0 ; i < queries; i++){
            res[i] = vals[indices[i]]; 
        }
        return res; 
    }
}
