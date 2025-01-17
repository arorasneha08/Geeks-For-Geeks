//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        
out.println("~");
}
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public class Pair{
        int row ;
        int col ; 
        Pair(int row , int col){
            this.row = row ;
            this.col = col ; 
        }
    }
    
    int numberOfEnclaves(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        Queue<Pair> q = new LinkedList<>() ; 
        int[][] visited = new int[n][m] ; 
        
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(i == 0 || i == n-1 || j == 0 || j == m-1){
                    if(grid[i][j] == 1){
                        visited[i][j] = 1; 
                        q.offer(new Pair(i, j)); 
                    }
                }
            }
        }
        
        int delRow[] = {-1, 0, 1, 0}; 
        int delCol[] = {0, -1, 0, 1} ; 
        int count = 0 ; 
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row ;
            int c = curr.col ;
            
            for(int i = 0 ; i < 4 ; i++){
                int newRow = delRow[i] + r ;
                int newCol = delCol[i] + c ; 
                
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m 
                && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 1){
                    visited[newRow][newCol] = 1 ; 
                    q.offer(new Pair(newRow , newCol));
                }
            }
        }
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    count ++ ; 
                }
            }
        }
        return count  ; 
    }
}