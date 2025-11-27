class Solution {
    public static class Pair implements Comparable<Pair>{
        int row; 
        int col ; 
        int dist ; 
        Pair(int row , int col , int dist){
            this.row = row; 
            this.col = col ; 
            this.dist = dist;
        }
        public int compareTo(Pair other){
            return this.dist - other.dist; 
        }
    }
    public static int[][] findDistance(char mat[][], int n, int m) {
       int res[][] = new int[n][m];
        int visited[][] = new int[n][m]; 
        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 'B'){
                    pq.offer(new Pair(i , j , 0));
                    visited[i][j] = 1;
                    res[i][j] = 0;
                } else if(mat[i][j] == 'W') {
                    res[i][j] = -1;
                }
            }
        }

        
        int delRow[] = {-1 , 0 , 1 , 0};
        int delCol[] = {0 , -1 , 0 , 1}; 
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll(); 
            int r = curr.row; 
            int c = curr.col ;
            int steps = curr.dist;
            
            res[r][c] = steps; 
            
            for(int i = 0 ; i < 4 ; i++){
                int newRow = delRow[i] + r ; 
                int newCol = delCol[i] + c; 
                
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && visited[newRow][newCol] == 0 && mat[newRow][newCol] == 'O'){
                    visited[newRow][newCol] = 1 ; 
                    pq.offer(new Pair(newRow , newCol ,steps + 1)); 
                }
            }
        }
        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 'O' && visited[i][j] == 0){
                    res[i][j] = -1; 
                }
            }
        }
        return res; 
    }
}