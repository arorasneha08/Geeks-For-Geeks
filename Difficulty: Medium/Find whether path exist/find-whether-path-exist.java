//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



class Solution {
    private class Pair{
        int row; 
        int col ; 
        Pair(int row , int col){
            this.row = row; 
            this.col = col ;
        }
    }
    public boolean is_Possible(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length; 
        int delRow[] = {-1 , 0 , 1 , 0};
        int delCol[] = {0 , 1 , 0 , -1};
        int[] src = new int[2] ;
        int dst[] = new int[2] ;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    src[0] = i ; 
                    src[1] = j ; 
                }
                else if(grid[i][j] == 2){
                    dst[0] = i ;
                    dst[1] = j ; 
                }
            }
        }
        Queue<Pair> q = new LinkedList<>();
        int visited[][] = new int[n][m]; 
        q.offer(new Pair(src[0] , src[1]));
        visited[src[0]][src[1]] = 1;  
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row; 
            int c = curr.col; 
            
            if(r == dst[0] && c == dst[1]){
                return true; 
            }
            
            for(int i = 0 ; i < 4 ; i++){
                int newRow = delRow[i] + r; 
                int newCol = delCol[i] + c ; 
                if(newRow >= 0 && newRow < n && newCol >= 0  
                && newCol < m && (grid[newRow][newCol] == 3 || grid[newRow][newCol] == 2)){
                    q.offer(new Pair(newRow , newCol)); 
                    visited[r][c] = 1; 
                }
            }
        }
        return false; 
    }
}