//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public class Pair{
        int node;
        int weight; 
        Pair(int n , int w){
            node = n ;
            weight = w ; 
        }
    }
    
    public void toposort(int node , int visited[] , Stack<Integer>st, ArrayList<ArrayList<Pair>> adj){
        visited[node] = 1 ;
        
        for(Pair adjNode : adj.get(node)){
            int v = adjNode.node ;
            int w = adjNode.weight; 
            if(visited[v] == 0){
                toposort(v, visited, st, adj); 
            }
        }
        st.push(node); 
    }
    
    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>(); 
        for(int i = 0 ; i<V ;i++){
            adj.add(new ArrayList<Pair>()); 
        }
        int visited[] = new int[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i<E ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v , w)); 
        }
        for(int i = 0 ; i<V ; i++){
            if(visited[i] == 0){
                toposort(i , visited, st , adj) ; 
            }
        }
        
        int distance[] = new int[V];
        Arrays.fill(distance , Integer.MAX_VALUE);
        distance[0] = 0 ;
        while(!st.isEmpty()){
            int currNode = st.pop(); 
            for(Pair adjNode : adj.get(currNode)){
                int v = adjNode.node; 
                int w = adjNode.weight;
                if(distance[currNode] != Integer.MAX_VALUE && distance[currNode] + w < distance[v]){
                    distance[v] = distance[currNode] + w ; 
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }
        return distance; 
    }
}