
class Solution {
    
    public class Pair implements Comparable<Pair>{
        int row ;
        int col ;
        int dist ; 
        Pair(int row ,int col ,int dist){
            this.row = row;
            this.col = col ;
            this.dist = dist; 
        }
        public int compareTo(Pair other){
            return this.dist - other.dist;
        }
    }
    
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length ;
        int delRow[] = {-1 , 0 , 1 , 0};
        int delCol[] = {0 , -1 , 0 , 1};
        
        if (grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0) {
            return -1;
        }
        
        Queue<Pair> q = new LinkedList<>(); 
        q.offer(new Pair(source[0], source[1], 0));
        int visited[][] = new int[n][m]; 
        visited[source[0]][source[1]] = 1; 
        
        while(!q.isEmpty()){
            Pair curr = q.poll(); 
            int r = curr.row ; 
            int c = curr.col ; 
            int s = curr.dist; 
            
            if(r == destination[0] && c == destination[1]) return s ; 
            
            for(int i = 0 ; i < 4 ; i++){
                int nr = delRow[i] + r ; 
                int nc = delCol[i] + c ;
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && visited[nr][nc] == 0 
                && grid[nr][nc] == 1){
                    visited[nr][nc] = 1 ;
                    q.offer(new Pair(nr , nc , s + 1)); 
                }
            }
        }
        return -1 ; 
    }
}
