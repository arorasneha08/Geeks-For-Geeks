class Solution {
    public class Pair{
        int row ; 
        int col ; 
        Pair(int row , int col){
            this.row = row ;
            this.col = col ;
        }
    }
    public void fill(char[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        Queue<Pair> q = new LinkedList<>(); 
        int visited[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 'O'){
                q.offer(new Pair(i, 0));
                visited[i][0] = 1;
            }
            if(grid[i][m - 1] == 'O'){
                q.offer(new Pair(i, m - 1));
                visited[i][m - 1] = 1;
            }
        }
        
        for(int j = 0; j < m; j++){
            if(grid[0][j] == 'O'){
                q.offer(new Pair(0, j));
                visited[0][j] = 1;
            }
            if(grid[n - 1][j] == 'O'){
                q.offer(new Pair(n - 1, j));
                visited[n - 1][j] = 1;
            }
        }

        int delRow[] = {-1 , 0 , 1 , 0};
        int delCol[] = {0 , -1 , 0 , 1};
        
        while(!q.isEmpty()){
            Pair curr = q.poll(); 
            int r = curr.row ;
            int c = curr.col ; 
            
            for(int i = 0 ; i < 4 ; i ++){
                int newRow = delRow[i] + r ; 
                int newCol = delCol[i] + c ; 
                if(newRow >= 0 && newCol >= 0 &&  newRow < n && newCol < m && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 'O'){
                    q.offer(new Pair(newRow , newCol)); 
                    visited[newRow][newCol] = 1 ; 
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(visited[i][j] == 0 && grid[i][j] == 'O'){
                    grid[i][j] = 'X'; 
                }
            }
        }
    }
}
