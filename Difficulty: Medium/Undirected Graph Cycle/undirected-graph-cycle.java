//{ Driver Code Starts
// Initial Template for Java
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
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    class Pair{
        int node ; 
        int parent; 
        Pair(int node , int parent){
            this.node = node; 
            this.parent = parent; 
        }
    } 
    public boolean detectCyclebfs(int src , List<List<Integer>> adj , int visited[]){
        visited[src] = 1 ; 
        Queue<Pair> q = new LinkedList<>() ; 
        q.offer(new Pair(src, -1)) ; 
        while(!q.isEmpty()){
            Pair p = q.poll(); 
            int currNode = p.node; 
            int parentNode = p.parent ; 
            for(int neighbour : adj.get(currNode)){
                if(visited[neighbour] == 0){
                    visited[neighbour] = 1 ; 
                    q.offer(new Pair(neighbour , currNode)) ; 
                }
                else if(parentNode != neighbour){
                    return true ;
                }
            }
        }
        return false; 
    }
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>()); 
        }
        for(int edge[] : edges){
            int u = edge[0] ;
            int v = edge[1]; 
            adj.get(u).add(v);
            adj.get(v).add(u); 
        }
        int visited[] = new int[V]; 
        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                if(detectCyclebfs(i, adj, visited)){
                return true;
            }
        }
    }
    return false;
    }
}