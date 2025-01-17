//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public class Pair{
        int node ;
        int parent ;
        Pair(int n , int p){
            node = n ; 
            parent = p; 
        }
    }
    
    public boolean detectCycle(int src , ArrayList<ArrayList<Integer>> adj , int visited[]){
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
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size() ; 
        int visited[] = new int[n]; 
        for(int i = 0 ; i<n ; i++){
            if(visited[i] == 0){
                if(detectCycle(i, adj , visited)){
                    return true ;
                }
            }
        }
        return false ; 
    }
}