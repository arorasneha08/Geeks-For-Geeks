//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking dimensions of the matrix
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    Solution ob = new Solution();
		    //calling method NumberOfPath()
		    System.out.println(ob.NumberOfPath(a,b));
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static int func(int i , int j , int dp[][]){
        if(i < 0 || j < 0) return 0 ; 
        if(i == 0 && j == 0){
            return 1 ; 
        }
        if(dp[i][j] != -1) return dp[i][j] ; 
        int up = func(i-1 , j , dp) ;
        int left = func(i , j-1 , dp );
        return dp[i][j] = up + left ;
    }
    public static int NumberOfPath(int a, int b) {
        int dp[][] = new int[a][b];
        for(int row[] : dp){
            Arrays.fill(row, -1); 
        }
        return func(a-1 , b-1 , dp ); 
    }
}