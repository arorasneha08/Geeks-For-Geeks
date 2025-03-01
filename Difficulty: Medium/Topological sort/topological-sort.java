//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            int vertices = Integer.parseInt(read.readLine());
            int edges = Integer.parseInt(read.readLine());

            for (int i = 0; i < vertices; i++) adj.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edges; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
            }

            ArrayList<Integer> res = new Solution().topologicalSort(adj);

            if (check(adj, vertices, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
            System.out.println("~");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> adj, int V,
                         ArrayList<Integer> res) {

        if (V != res.size()) return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res.get(i)] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends




class Solution {
    static void dfs(int node , ArrayList<ArrayList<Integer>> adj , int[] visited,Stack<Integer> st){
        visited[node] = 1 ; 
        for(int adjNode : adj.get(node)){
            if(visited[adjNode] == 0){
                dfs(adjNode , adj , visited, st); 
            }
        }
        st.push(node); 
    }
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // int n = adj.size() ; 
        // int indegree[] = new int[n] ; 
        // for(int i= 0 ; i<n ; i++){
        //     for(int adjNode : adj.get(i)){
        //         indegree[adjNode]++ ; 
        //     }
        // }
        // Queue<Integer> q = new LinkedList<>() ; 
        // for(int i = 0 ; i<n ; i++){
        //     if(indegree[i] == 0){
        //         q.offer(i); 
        //     }
        // }
        // ArrayList<Integer> list = new ArrayList<>() ; 
        // while(!q.isEmpty()){
        //     int node = q.poll() ;
        //     list.add(node); 
            
        //     for(int adjNode : adj.get(node)){
        //         indegree[adjNode]-- ; 
        //         if(indegree[adjNode] == 0) q.offer(adjNode); 
        //     }
        // }
        // return list ; 
        
        int n = adj.size() ;
        int[] visited = new int[n]; 
        ArrayList<Integer> ans = new ArrayList<>() ; 
        Stack<Integer> st = new Stack<>(); 
        
        for(int i = 0 ; i<n ; i++){
            if(visited[i] == 0){
                dfs(i, adj , visited , st); 
            }
        }
        while(!st.isEmpty()){
            ans.add(st.pop()); 
        }
        return ans ; 

    }
}