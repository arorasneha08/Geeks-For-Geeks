//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u); // Since the graph is undirected
            }

            int src = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.shortestPath(adj, src);

            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int n = adj.size(); 
        int distance[] = new int[n] ;
        Arrays.fill(distance, Integer.MAX_VALUE) ;
        distance[src]  = 0 ;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(src) ;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            
            for(int adjNode : adj.get(curr)){
                if(distance[curr] + 1 < distance[adjNode]){
                    distance[adjNode] = distance[curr] + 1 ; 
                    q.offer(adjNode); 
                }
            }
        }
        
        for(int i = 0 ; i<n ; i++){
            if(distance[i] == Integer.MAX_VALUE){
                distance[i] = -1 ; 
            }
        }
        return distance; 
    }
}
