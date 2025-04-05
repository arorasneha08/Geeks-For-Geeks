//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    public class Pair{
        int row ; 
        int col ; 
        Pair(int row , int col){
            this.row = row ;
            this.col = col ; 
        }
    }
    private void bfs(int row , int col , int visited[][] , char grid[][]){
        int delRow[] = {-1 , -1 , -1 , 0 , 0 , 1 , 1 , 1}; 
        int delCol[] = {-1,  0 , 1, -1 , 1, -1 , 0 , 1 } ; 
        int n = grid.length;
        int m = grid[0].length;
        
        visited[row][col] = 1; 
        Queue<Pair> q = new LinkedList<>(); 
        
        q.offer(new Pair(row , col));
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row ;
            int c = curr.col ; 
            for(int i = 0 ; i < 8 ; i++){
                int newRow = delRow[i] + r ;
                int newCol = delCol[i] + c ; 
                if(newRow >= 0 && newRow < n && newCol >=0 && newCol < m && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 'L'){
                    visited[newRow][newCol] = 1 ; 
                    q.offer(new Pair(newRow, newCol));
                }
            }
        }
    }
    public int countIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length ; 
        int visited[][] = new int[n][m]; 
        int count = 0 ; 
       
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 'L' && visited[i][j] == 0){
                    count ++ ; 
                    bfs(i , j , visited , grid); 
                }
            }
        }
        return count; 
    }
}