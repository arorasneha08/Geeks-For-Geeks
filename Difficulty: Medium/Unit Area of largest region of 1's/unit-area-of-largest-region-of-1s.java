class Solution {
    
    public int dfs(int r , int c , int grid[][] , int visited[][] , int n , int m){
        int delRow[] = {-1 , -1 , -1 , 0, 0, 1 , 1, 1};
        int delCol[] = {-1 , 0 , 1, -1 , 1 , -1 , 0, 1}; 
        
        visited[r][c] = 1 ; 
        int count = 1 ;  
        
        for(int i = 0 ; i < 8 ; i++){
            int nr = delRow[i] + r ; 
            int nc = delCol[i] + c ; 
            
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && visited[nr][nc] == 0 && grid[nr][nc] == 1){
                count += dfs(nr , nc , grid , visited , n , m); 
            }
        }
        return count ; 
    }
    public int findMaxArea(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        
        int maxArea = 0 ; 
        int visited[][] = new int[n][m]; 
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    int area = dfs(i , j , grid , visited , n , m);
                    maxArea = Math.max(maxArea , area); 
                }
            }
        }
        return maxArea ; 
    }
}