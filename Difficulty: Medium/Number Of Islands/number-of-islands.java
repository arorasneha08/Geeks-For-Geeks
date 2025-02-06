//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    class DisjointSet{
        List<Integer> rank;
        List<Integer> parent;
    
        public DisjointSet(int n) {
            rank = new ArrayList<>(n);
            parent = new ArrayList<>(n);
            
            for (int i = 0; i < n; i++) {
                rank.add(0);
                parent.add(i);
            }
        }
    
        public int findUParent(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ul_parent = findUParent(parent.get(node)); 
            parent.set(node, ul_parent); // Path compression
            return ul_parent;
        }
    
        public void unionByRank(int u, int v) {
            int ul_parent_u = findUParent(u);
            int ul_parent_v = findUParent(v);
    
            if (ul_parent_u == ul_parent_v) return; // Already in the same set
    
            if (rank.get(ul_parent_u) < rank.get(ul_parent_v)) {
                parent.set(ul_parent_u, ul_parent_v);
            } else if (rank.get(ul_parent_u) > rank.get(ul_parent_v)) {
                parent.set(ul_parent_v, ul_parent_u);
            } else {
                parent.set(ul_parent_v, ul_parent_u);
                rank.set(ul_parent_u, rank.get(ul_parent_u) + 1);
            }
        }
    }
    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        List<Integer> ans = new ArrayList<>(); 
        int[][] visited = new int[n][m]; 
        
        DisjointSet ds = new DisjointSet(n * m); 
        int len = operators.length ; 
        int count = 0 ;
        for(int i = 0 ; i < len ; i++){
            int row = operators[i][0] ;
            int col = operators[i][1]; 
            if(visited[row][col] == 1){
                ans.add(count)  ;
                continue;  
            }
            visited[row][col] = 1; 
            count ++ ; 
            int delRow[] = {-1 , 0, 1, 0} ;
            int delCol[] = {0 , 1 , 0 , -1} ;
            
            for(int j = 0 ; j < 4 ; j++){
                int newRow = delRow[j] + row ; 
                int newCol = delCol[j] + col ;
                
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol <m && visited[newRow][newCol] == 1){
                    int nodeNo = row * m + col; 
                    int adjNodeNo = newRow * m + newCol ;
                    
                    if(ds.findUParent(nodeNo) != ds.findUParent(adjNodeNo)){
                        count -- ; 
                        ds.unionByRank(nodeNo , adjNodeNo); 
                    }
                }
            }
            ans.add(count); 
        }
        return ans ; 
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends