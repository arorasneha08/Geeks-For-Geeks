//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            new Solution().setMatrixZeroes(arr);
            for (int[] row : arr) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int r = mat.length ;
        int c = mat[0].length ; 
        int col0 = 1 ; 
        for(int i = 0 ; i<r ; i++){
            for(int j = 0; j< c ; j++){
                if(mat[i][j] == 0){
                    mat[i][0] = 0 ; 
                    if(j != 0){
                        mat[0][j] = 0 ; 
                    }
                    else{
                        col0 = 0 ; 
                    }
                }
            }
        }
        for(int i = 1 ; i<r ; i++){
            for(int j = 1; j<c ; j++){
                if(mat[i][0] == 0 || mat[0][j] == 0){
                    mat[i][j] = 0 ; 
                }
            }
        }
        if(mat[0][0] == 0){
            for(int j = 0 ;j< c; j++){
                mat[0][j] = 0;
            }
        }
        if(col0 == 0){
            for(int i = 0 ; i<r ; i++){
                mat[i][0] = 0 ; 
            }
        }
    }
}