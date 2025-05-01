//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Integer> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);

            System.out.println("~");
        }
    }

    public static void printAns(ArrayList<Integer> ans) {
        for (Integer x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int  i = 0 ;  i< n ; i++){
            ArrayList<Integer> list = new ArrayList<>(); 
            for(int j = 0 ; j <= i ; j++){
                if(i== j || j == 0 ){
                    list.add(1);
                }
                else {
                    int val= res.get(i-1).get(j) + res.get(i-1).get(j-1); 
                    list.add(val); 
                }
            }
            res.add(list); 
        }
        return res.get(n-1); 
    }
}