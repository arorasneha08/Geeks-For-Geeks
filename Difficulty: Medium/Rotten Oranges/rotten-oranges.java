//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public class Pair{
        int row ;
        int col ; 
        Pair(int r , int c){
            row = r ; 
            col = c ; 
        }
    }
    public int orangesRotting(int[][] mat) {
        int n = mat.length ;
        int m = mat[0].length ; 
        int fresh = 0 ; 
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 2){
                    q.offer(new Pair(i , j)); 
                }
                if(mat[i][j] == 1){
                    fresh ++ ; 
                }
            }
        }
        if (fresh == 0) return 0;
        int time = 0 ; 
        int delRow[] = {-1 , 0 , 1, 0};
        int delCol[] = {0 , 1 , 0 , -1}; 
        
        while(!q.isEmpty()){
            int size = q.size();
            boolean rotted = false; 
            for(int i = 0 ; i < size ; i++){
                Pair curr = q.poll(); 
                int row = curr.row ;
                int col = curr.col ; 
            
                for(int j = 0 ; j < 4 ; j++){
                    int newRow = delRow[j] + row ; 
                    int newCol = delCol[j] + col ; 
                    if(newRow >= 0 && newRow < n && newCol>=0  && newCol < m && mat[newRow][newCol] == 1){
                        mat[newRow][newCol] = 2 ;
                        fresh -- ; 
                        q.offer(new Pair(newRow , newCol)); 
                        rotted = true; 
                    }
                }
            }
            if(rotted) time ++ ; 
            
        }
        if(fresh == 0) return time ;
        return -1; 
    }
}