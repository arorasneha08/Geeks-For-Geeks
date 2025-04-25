//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        int elem = -1 ;
        int n = arr.length ;
        int count = 0 ; 
        for(int i = 0 ; i<n ; i++){
            if(count == 0){
                count = 1 ; 
                elem = arr[i] ;
            }
            else if(elem == arr[i]){
                count ++ ; 
            }
            else{
                count --; 
            }
        }
        int count1 = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == elem){
                count1 ++ ;
            }
        }
        if(count1 > n/2){
            return elem ;
        }
        return -1 ;
    }
}