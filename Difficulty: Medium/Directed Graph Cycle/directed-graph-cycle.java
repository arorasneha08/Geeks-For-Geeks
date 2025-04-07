//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0 ; i < V ; i++){
            adj.add(new ArrayList<>()); 
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1]; 
            adj.get(u).add(v); 
            
        }
        int n = adj.size() ; 
        int indegree[] = new int[n] ; 
        for(int i= 0 ; i<n ; i++){
            for(int adjNode : adj.get(i)){
                indegree[adjNode]++ ; 
            }
        }
        Queue<Integer> q = new LinkedList<>() ; 
        for(int i = 0 ; i<n ; i++){
            if(indegree[i] == 0){
                q.offer(i); 
            }
        }
        int count = 0 ; 
        while(!q.isEmpty()){
            int node = q.poll(); 
            count ++ ; 
            
            for(int adjNode : adj.get(node)){
                indegree[adjNode]-- ; 
                if(indegree[adjNode] == 0) q.offer(adjNode); 
            }
        }
        if(count == n){
            return false ;
        } 
        return true; 
    }
}