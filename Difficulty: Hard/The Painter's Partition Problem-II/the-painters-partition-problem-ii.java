//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int n = input_line.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minTime(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int max(int arr[]){
        int max = 0 ;
        for(int i = 0 ; i<arr.length ; i++){
            if(max < arr[i]){
                max = arr[i] ;
            }
        }
        return max ; 
    }
    public int sum(int arr[]){
        int sum = 0;
        for(int i = 0 ; i<arr.length; i++){
            sum += arr[i] ;
        }
        return sum ; 
    }
    public static boolean isPossible(int arr[] , int mid , int k){
            int painter = 1 ; 
            int time = 0 ;
        for(int i = 0; i<arr.length ; i++){
            if(time + arr[i] <= mid){
                time += arr[i] ; 
            }
            else{
                painter ++; 
                time = arr[i] ;
                if(painter > k) return false;
            }
        }
        return true ; 
    }
    public int minTime(int[] arr, int k) {
        int n = arr.length ;
        int start = max(arr) ;
        int ans  = 0 ; 
        int end = sum(arr) ;
        while(start <= end){
            int mid = (start + end)/2 ;
            if(isPossible(arr, mid , k)){
                ans = mid ;
                end = mid - 1 ; 
            }
            else{
                start = mid + 1; 
            }
        }
        return ans ; 
    }
}
