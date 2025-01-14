//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            // Reading the first array
            String line1 = read.readLine().trim();
            String[] numsStr1 = line1.split(" ");
            int[] a = new int[numsStr1.length];
            for (int i = 0; i < numsStr1.length; i++) {
                a[i] = Integer.parseInt(numsStr1[i]);
            }

            // Reading the second array
            String line2 = read.readLine().trim();
            String[] numsStr2 = line2.split(" ");
            int[] b = new int[numsStr2.length];
            for (int i = 0; i < numsStr2.length; i++) {
                b[i] = Integer.parseInt(numsStr2[i]);
            }

            // Creating an instance of the Solution class
            Solution ob = new Solution();

            // Calling doUnion method and printing the result
            System.out.println(ob.findUnion(a, b));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int findUnion(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b); 
       int n1 = a.length ; 
       int n2 = b.length ; 
       int i = 0 ;
       int j = 0 ; 
       ArrayList<Integer> ans = new ArrayList<>(); 
       while(i < n1 && j < n2){
           if(a[i] == b[j]){
               if(ans.isEmpty() || ans.get(ans.size()-1) != a[i]){
                   ans.add(a[i]); 
               }
               i++ ;
               j++;
           }
           else if(a[i] < b[j]){
               if(ans.isEmpty() || ans.get(ans.size()-1) != a[i]){
                   ans.add(a[i]);
               }
               i++ ;
           }
           else{
               if(ans.isEmpty() || ans.get(ans.size()-1) != b[j]){
                   ans.add(b[j]);
               }
               j++;
           }
       }
       while(i < n1){
           if(ans.isEmpty() || ans.get(ans.size()-1) != a[i]){
               ans.add(a[i]);
           }
           i++ ; 
       }
       while(j < n2){
           if(ans.isEmpty() || ans.get(ans.size()-1) != b[j]){
               ans.add(b[j]); 
           }
           j++ ; 
       }
       return ans.size(); 
    }
}