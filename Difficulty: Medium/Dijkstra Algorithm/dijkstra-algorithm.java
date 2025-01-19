//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class DriverClass {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<iPair>> adj = new ArrayList<ArrayList<iPair>>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<iPair>());
            }

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                iPair t1 = new iPair(v, w);
                iPair t2 = new iPair(u, w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }

            int src = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.dijkstra(adj, src);

            for (i = 0; i < V; i++) System.out.print(res.get(i) + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*
class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
*/

// User function Template for Java
class Solution {
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        PriorityQueue<iPair> pq = new PriorityQueue<>((a,b)-> a.second - b.second);
        int n = adj.size(); 
        ArrayList<Integer> distance = new ArrayList<>() ;
        for(int i = 0 ; i<n ; i++){
            distance.add((int)1e9); 
        }
        distance.set(src, 0); 
        pq.add(new iPair(src, 0));
        
        while(!pq.isEmpty()){
            iPair curr = pq.poll();
            int node = curr.first ;
            int dist = curr.second;
            
            for(iPair neighbour : adj.get(node)){
                int adjNode = neighbour.first ;
                int weight = neighbour.second;
                
                if(dist + weight < distance.get(adjNode)){
                    distance.set(adjNode, dist + weight);
                    pq.add(new iPair(adjNode, dist + weight));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (distance.get(i) == (int) 1e9) {
                distance.set(i, -1);
            }
        }
        return distance; 
    }
}