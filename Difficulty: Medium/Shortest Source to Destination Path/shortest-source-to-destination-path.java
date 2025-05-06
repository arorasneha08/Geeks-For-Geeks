//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private class Pair{
        int row; 
        int col ; 
        int steps ; 
        Pair(int r , int c , int s){
            row =r ;
            col = c; 
            steps = s ;
        }
    }
    int shortestDistance(int n, int m, int mat[][], int X, int Y) {
        int delRow[] = {-1 , 0 , 1 , 0};
        int delCol[] = {0 , 1 , 0 , -1}; 
        Queue<Pair> q = new LinkedList<>();
        if(mat[0][0] == 0) return -1 ; 
        q.offer(new Pair(0, 0, 0)); 
        mat[0][0] = 0;
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row; 
            int c = curr.col ;
            int d = curr.steps; 
            
            if(r == X && c == Y){
                return d; 
            }
            
            for(int i = 0 ; i < 4;  i++){
                int newRow = delRow[i] + r ; 
                int newCol = delCol[i] + c ; 
                if(newRow >= 0 && newRow < n && newCol >=0 && newCol < m && 
                mat[newRow][newCol] == 1){
                    q.offer(new Pair(newRow, newCol , d+1)); 
                     mat[newRow][newCol] = 0;
                }
            }
        }
        return -1; 
    }
};