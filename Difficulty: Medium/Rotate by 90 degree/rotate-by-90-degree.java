//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();

            GFG g = new GFG();
            g.rotate(arr);
            printMatrix(arr);

            System.out.println("~");
        }
    }

    static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class GFG {
    static void reverse(int arr[] , int left , int right){
        while(left <right){
            int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp ; 
        left ++ ;
        right --; 
        }
    }
    static void swap(int arr[][] , int left , int right){
        int temp = arr[left][right];
        arr[left][right] = arr[right][left];
        arr[right][left] = temp ; 
    }
    static void rotate(int mat[][]) {
        int r = mat.length ;
        int c = mat[0].length ;
        for(int i = 0 ; i<r; i++){
            for(int j = 0 ; j< i; j++){
                swap(mat, i, j); 
            }
        }
        for(int i = 0 ; i<r ; i++){
            reverse(mat[i], 0, c-1); 
        }
    }
}