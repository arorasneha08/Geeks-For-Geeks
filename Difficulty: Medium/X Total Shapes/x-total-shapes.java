

class Solution {
    private void dfs(int r , int c , char grid[][] , int visited[][] , int n , int m){
        visited[r][c] = 1; 
        int delRow[] = {-1 , 0 , 1 , 0}; 
        int delCol[] = {0 , -1 , 0 , 1}; 
        
        for(int i = 0 ; i < 4 ; i++){
            int nr = delRow[i] + r ; 
            int nc = delCol[i] + c; 
            if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                if(visited[nr][nc] == 0 && grid[nr][nc] == 'X'){
                    dfs(nr , nc , grid , visited , n , m); 
                }
            }
        }
    }
    public int xShape(char[][] grid) {
        int n = grid.length; 
        int m = grid[0].length ;
        int count = 0 ; 
        int visited[][] = new int[n][m]; 
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 'X'){
                    if(visited[i][j] == 0){
                        count ++; 
                        dfs(i , j , grid , visited , n , m);
                    }
                }
            }
        }
        return count ;
    }
}