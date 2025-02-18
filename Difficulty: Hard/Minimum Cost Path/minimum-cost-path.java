//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution{
    public class Pair implements Comparable<Pair>{
        int row ;
        int col ; 
        int cost ;
        Pair(int r , int c, int cost){
            row = r ;
            col = c ; 
            this.cost = cost ;
        }
        public int compareTo(Pair other){
            return this.cost - other.cost;  
        }
    }
    public int minimumCostPath(int[][] grid){
        int n = grid.length ;
        int m = grid[0].length ; 
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        int dist[][] = new int[n][m] ;
        for(int row[] : dist){
            Arrays.fill(row , Integer.MAX_VALUE); 
        }
        dist[0][0] = grid[0][0];
        pq.offer(new Pair(0 , 0 , grid[0][0])); 
        
        int delRow [] = {-1 , 0 , 1 , 0}; 
        int delCol [] = {0, -1 , 0 , 1}; 
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int r = curr.row;
            int c = curr.col ;
            int d = curr.cost; 
            if(r == n-1 && c == m-1) return d; 
            
            for(int i = 0 ;i < 4 ; i++){
                int newRow = r + delRow[i];
                int newCol = c + delCol[i]; 
                
                if(newRow >= 0 && newRow <n && newCol >= 0 && newCol < m){
                    if(d+ grid[newRow][newCol] < dist[newRow][newCol]){
                        dist[newRow][newCol] = d + grid[newRow][newCol] ; 
                        pq.offer(new Pair(newRow , newCol , dist[newRow][newCol]));
                    }
                }
            }
        }
        return -1; 
    }
}