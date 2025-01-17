//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution {
    public class Pair{
        int row ;
        int col ; 
        Pair(int row, int col){
            this.row = row ;
            this.col = col ; 
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return row == pair.row && col == pair.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
    
    void dfs(int row , int col , int[][] grid , ArrayList<Pair> list , int[][] visited , HashSet<ArrayList<Pair>> set , int row0, int col0 , int n , int m){
        visited[row][col] = 1 ; 
        list.add(new Pair(row - row0 , col - col0)); 
        
        int delRow[] = {-1,0,1,0} ;
        int delCol[] = {0,-1,0,1};
        
        for(int i = 0 ; i<4 ; i++){
            int newRow = delRow[i] + row ;
            int newCol = delCol[i] + col ; 
            
            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m 
            && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 1){
                dfs(newRow, newCol , grid , list , visited , set , row0, col0 , n, m); 
            }
        }
    }

    int countDistinctIslands(int[][] grid) {
        int n = grid.length; 
        int m = grid[0].length ;
        int[][] visited = new int[n][m] ;
        HashSet<ArrayList<Pair>> set = new HashSet<>(); 
         
        for(int i = 0 ; i<n ;i++){
            for(int j = 0; j < m ; j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<Pair> list = new ArrayList<>(); 
                    dfs(i, j, grid, list, visited, set , i, j , n , m) ; 
                    set.add(list) ;
                }
            }
        }
        return set.size(); 
    }
}
