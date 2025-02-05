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
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));

            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static class Pair implements Comparable<Pair>{
        int node ;
        int distance; 
        Pair(int n , int d){
            node = n ;
            distance = d ; 
        }
        public int compareTo(Pair other){
            return this.distance - other.distance ; 
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        int sum = 0 ; 
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] visited = new int[V] ; 
        Arrays.fill(visited , 0 ); 
        pq.offer(new Pair(0,0)); 
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node; 
            int dist = curr.distance ; 
            
            if (visited[node] == 1) continue;
            
            visited[node] = 1; 
            sum += dist ; 
            
            for(int[] adjNode : adj.get(node)){
                int n = adjNode[0];
                int d = adjNode[1]; 
                if(visited[n] == 0){
                    pq.offer(new Pair(n , d)); 
                }
            }
        }
        return sum ; 
    }
}