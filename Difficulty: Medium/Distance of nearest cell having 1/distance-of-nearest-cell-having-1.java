class Solution {
    public class Pair{
        int row ;
        int col ; 
        int steps ; 
        Pair(int row , int col , int steps){
            this.row = row; 
            this.col = col ; 
            this.steps = steps; 
        }
    }
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(0); 
            }
            res.add(row);
        }
        
        Queue<Pair> q = new LinkedList<>(); 
        boolean visited[][] = new boolean[n][m]; 
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(grid[i][j] == 1){
                    q.offer(new Pair(i, j , 0)); 
                    visited[i][j] = true ; 
                }
            }
        }
        int delRow[] = {-1 , 0 , 1 , 0};
        int delCol[] = {0 , 1 , 0 , -1}; 
        
        while(!q.isEmpty()){
            Pair curr = q.poll(); 
            int r = curr.row ; 
            int c = curr.col ; 
            int s = curr.steps ;
            res.get(r).set(c, s);  
            
            for(int i = 0 ; i < 4 ; i ++){
                int newRow = r + delRow[i]; 
                int newCol = c + delCol[i]; 
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol]){
                    visited[newRow][newCol] = true ; 
                    q.offer(new Pair(newRow , newCol , s + 1)); 
                }
            }
        }
        return res; 
    }
}