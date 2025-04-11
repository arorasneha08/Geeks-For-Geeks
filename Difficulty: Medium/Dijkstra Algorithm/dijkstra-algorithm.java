//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            int src = Integer.parseInt(sc.nextLine());

            Solution obj = new Solution();
            int[] res = obj.dijkstra(V, edges, src);

            for (int val : res) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public class Pair{
        int node ;
        int dist ; 
        Pair(int node , int dist){
            this.node = node;
            this.dist = dist; 
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<Pair>> adj = new ArrayList<>(); 
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist); 
        int distance[] = new int[V];
        
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>()); 
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2]; 
            adj.get(u).add(new Pair(v, w)); 
        }
        Arrays.fill(distance , Integer.MAX_VALUE); 
        distance[src] = 0 ;
        pq.offer(new Pair(src , 0)); 
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int dist = curr.dist; 
            
            for(Pair neighbour : adj.get(node)){
                int adjNode = neighbour.node ;
                int weight = neighbour.dist ;
                
                if(dist + weight < distance[adjNode]){
                    distance[adjNode] = dist + weight ; 
                    pq.offer(new Pair(adjNode , distance[adjNode])); 
                }
            }
        }
        
        return distance; 
    }
}