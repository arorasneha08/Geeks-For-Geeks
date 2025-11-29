class Solution {
    private void dfs(int r , int c , int visited[][], char grid[][] , int n , int m){
        int delRow[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int delCol[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        
        visited[r][c] = 1;  
        
        for(int i = 0 ; i < 8 ; i++){
            int nr = delRow[i] + r ;
            int nc = delCol[i] + c; 
            
            
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && visited[nr][nc] == 0 && grid[nr][nc] == 'L'){
                dfs(nr , nc , visited , grid , n , m); 
            }
        }
    }
    public int countIslands(char[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length; 
        int count = 0  ; 
        int visited[][] = new int[n][m]; 
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 'L' && visited[i][j] == 0){
                    dfs(i , j , visited , grid, n , m); 
                    count ++; 
                }
            }
        }
        return count ; 
    }
}