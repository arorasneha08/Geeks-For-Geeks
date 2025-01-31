//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isValid(int digit , int[][] mat , int n , int row , int col){
        for(int i = 0 ; i< 9 ; i++){
            if(mat[i][col] == digit) return false; 
            if(mat[row][i] == digit) return false; 
            if(mat[3 * (row / 3) +  i / 3][3 * (col/ 3) + i % 3] == digit) return false; 
        }
        return true; 
    }
    static boolean solve(int [][] mat , int n){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 0){
                    for(int k = 1 ; k<= 9 ; k++){
                        if(isValid(k , mat , n , i , j)){
                            mat[i][j] = k ; 
                            if(solve(mat , n)){
                                return true; 
                            }
                            else{
                                mat[i][j] = 0 ; 
                            }
                        }
                    }
                    return false; 
                }
            }
        }
        return true;  
    }
    static void solveSudoku(int[][] mat) {
        int n = mat.length ; 
        solve(mat , n); 
    }
}