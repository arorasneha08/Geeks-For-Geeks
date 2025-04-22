//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            int[][] edges = new int[E][3];
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }
            ot.println(new Solution().kruskalsMST(V, edges));
            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends


class Solution {
    static class DisjointSet{
        List<Integer> parent;
        List<Integer> rank ;
        
        DisjointSet(int n){
            parent = new ArrayList<>();
            rank = new ArrayList<>();
            
            for(int i = 0 ; i < n ; i++){
                parent.add(i);
                rank.add(0); 
            }
        }
        
        private int findParent(int node){
            if(node == parent.get(node)){
                return node; 
            }
            int ul_parent = findParent(parent.get(node)); 
            parent.set(node , ul_parent); 
            return ul_parent; 
        }
        private void unionByRank(int u , int v){
            int ul_parent_u = findParent(u);
            int ul_parent_v = findParent(v);
            
            if(ul_parent_u == ul_parent_v) return ; 
            
            if(rank.get(ul_parent_u) < rank.get(ul_parent_v)){
                parent.set(ul_parent_u , ul_parent_v); 
            }
            else if(rank.get(ul_parent_v) < rank.get(ul_parent_u)){
                parent.set(ul_parent_v, ul_parent_u); 
            }
            else {
                parent.set(ul_parent_v , ul_parent_u);
                rank.set(ul_parent_u , rank.get(ul_parent_u) + 1); 
            }
        }
    }
    static int kruskalsMST(int V, int[][] edges) {
        Arrays.sort(edges , (a , b) -> Integer.compare(a[2], b[2])); 
        DisjointSet ds = new DisjointSet(V);
        int minWt = 0 ; 
        
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            if(ds.findParent(u) != ds.findParent(v)){
                minWt += w ; 
                ds.unionByRank(u , v); 
            }
        }
        return minWt ; 
    }
}
