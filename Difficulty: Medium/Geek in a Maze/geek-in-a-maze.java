//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

// } Driver Code Ends

// User function Template for Java

class Solution {
    private static class Pair{
        int x; 
        int y ;
        int u ;
        int d; 
        
        Pair(int x , int y , int u , int d){
            this.x = x ;
            this.y = y ; 
            this.u = u ; 
            this.d = d; 
        }
    }
    
    public static int numberOfCells(int n, int m, int r, int c, int u, int d,char mat[][]){
        if(mat[r][c] == '#') return 0;
        int visited[][] = new int[n][m]; 
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(r, c, 0 , 0));
        int count = 0 ; 
        visited[r][c] = 1; 
        
        while(!q.isEmpty()){
            Pair curr = q.pollFirst();
            int row = curr.x; 
            int col = curr.y ;
            int up = curr.u ;
            int down = curr.d; 
            visited[row][col] = 1; 
            count ++ ; 
            
            // left
            if(col-1 >= 0 && mat[row][col-1] == '.' && visited[row][col-1] == 0){
                q.offerFirst(new Pair(row, col-1 , up , down)); 
                visited[row][col-1]  = 1 ; 
            }
            // right
            if(col+1 < m && mat[row][col+1] == '.' && visited[row][col+1] == 0){
                q.offerFirst(new Pair(row , col+ 1 , up , down)); 
                visited[row][col+1] = 1 ; 
            }
            // top 
            if(up < u && row-1 >= 0 && mat[row-1][col] == '.' && visited[row-1][col] == 0){
                q.offerLast(new Pair(row-1 , col , up+1 , down)); 
                visited[row-1][col] = 1; 
            }
            // down
            if(down < d && row+1 < n && mat[row+1][col] == '.' && visited[row+1][col] == 0){
                q.offerLast(new Pair(row+1 , col , up , down+1)); 
                visited[row+1][col] = 1; 
            }
        }
        return count; 
    }
}




//{ Driver Code Starts.

public class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0)
		{
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int r = sc.nextInt();
		    int c = sc.nextInt();
		    int u = sc.nextInt();
		    int d = sc.nextInt();
		    
		    char mat[][] = new char[n][m];

            for(int i = 0; i < n; i++)
            {
                String s = sc.next();
                for(int j = 0; j < m; j++)
                {
                    mat[i][j] = s.charAt(j);
                }
            }
            
            Solution obj = new Solution();
            System.out.println(obj.numberOfCells(n, m, r, c, u, d, mat));
		    
		}
	}
}


// } Driver Code Ends