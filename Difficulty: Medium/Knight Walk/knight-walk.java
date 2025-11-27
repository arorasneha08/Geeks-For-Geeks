class Solution {
    public class Pair implements Comparable<Pair>{
        int row ; 
        int col ;
        int dist; 
        Pair(int row , int col , int dist){
            this.row = row; 
            this.col = col ;
            this.dist = dist; 
        }
        public int compareTo(Pair other){
            return this.dist - other.dist; 
        }
    }
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        int delRow[] = {-2 , -2 , 2, 2, -1 , -1, 1 , 1}; 
        int delCol[] = {-1 , 1, -1, 1, -2, 2, -2 , 2} ; 
        int visited[][] = new int[n][n]; 
        visited[knightPos[0]-1][knightPos[1]-1] = 1 ;
        pq.offer(new Pair(knightPos[0]-1 , knightPos[1]-1 , 0)); 
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll(); 
            int r = curr.row; 
            int c = curr.col ;
            int d = curr.dist ;
            
            if(r == targetPos[0]-1 && c == targetPos[1]-1){
                return d ; 
            }
            
            for(int i = 0 ; i < 8 ; i++){
                int newRow = delRow[i] + r ; 
                int newCol = delCol[i] + c ; 
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && visited[newRow][newCol] == 0){
                    visited[newRow][newCol] = 1 ;
                    pq.offer(new Pair(newRow , newCol , d + 1)); 
                }
            }
        }
        return -1; 
    }
}