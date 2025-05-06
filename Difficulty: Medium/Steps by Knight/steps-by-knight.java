//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] knightPos = new int[2];
            int[] targetPos = new int[2];
            for (int i = 0; i < 2; i++) {
                knightPos[i] = Integer.parseInt(S1[i]);
                targetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(knightPos, targetPos, n);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public class Pair{
        int x ;
        int y ; 
        int dist; 
        
        Pair(int x, int y , int dist){
            this.x = x ; 
            this.y = y ; 
            this.dist = dist; 
        }
    }
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        int startX = knightPos[0]-1;
        int startY = knightPos[1] - 1;
        int tarX = targetPos[0] - 1;  
        int tarY = targetPos[1] - 1 ; 
        int visited[][] = new int[n][n]; 
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(startX , startY , 0)); 
        visited[startX][startY] = 1 ;
        
        int[] delRow = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] delCol = {1, 2, 2, 1, -1, -2, -2, -1};
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int row = curr.x; 
            int col = curr.y ; 
            int d = curr.dist; 
            
            if(row == tarX && col == tarY){
                return d;  
            }
            
            for(int i =0 ; i < 8 ; i++){
                int newRow = delRow[i] + row; 
                int newCol = delCol[i] + col ;
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && 
                visited[newRow][newCol] == 0 ){
                    visited[newRow][newCol] = 1 ; 
                    q.offer(new Pair(newRow , newCol , d+1)); 
                }
            }
        }
        return -1; 
    }
}