//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                ans.sort((list1, list2) -> {
                    int size = Math.min(list1.size(), list2.size());
                    for (int i = 0; i < size; i++) {
                        if (!list1.get(i).equals(list2.get(i))) {
                            return list1.get(i) - list2.get(i);
                        }
                    }
                    return list1.size() - list2.size();
                });

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public void helper(int row , boolean[] col , boolean[] upperDiag , 
    boolean[] lowerDiag , int [] board , ArrayList<ArrayList<Integer>> result
    , int n){
        
        if(row == n){
            result.add(constructBoard(board , n)) ;
            return ; 
        }
        for(int c = 0 ; c < n ; c++){
            if(col[c] || upperDiag[n-1+row-c] || lowerDiag[row + c]) continue;
            
            board[row] = c + 1 ; 
            col[c] = true ;
            upperDiag[n-1+row-c] = true ; 
            lowerDiag[row + c] = true ; 
            
            helper(row + 1 , col , upperDiag , lowerDiag , board , result , n); 
            
            col[c] = false ;
            upperDiag[n-1+row-c] = false ; 
            lowerDiag[row + c] = false ; 
        }
    }
    public ArrayList<Integer> constructBoard(int[] board, int n){
        ArrayList<Integer> res = new ArrayList<>() ; 
        for(int b : board){
            res.add(b); 
        }
        return res; 
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] board = new int[n]; 
        
        boolean col[] = new boolean[2 * n]; 
        boolean upperDiag[] = new boolean[2*n] ;
        boolean lowerDiag[] = new boolean[2*n]; 
        helper(0 , col, upperDiag , lowerDiag , board , result , n); 
        return result ; 
    }
}