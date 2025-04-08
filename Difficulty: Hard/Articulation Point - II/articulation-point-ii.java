//{ Driver Code Starts
import java.util.*;

public class Main {
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
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] time = {0}; // Global time counter
        int[] disc = new int[V]; // Discovery times
        int[] low = new int[V];  // Low-link values
        boolean[] visited = new boolean[V];
        boolean[] isAP = new boolean[V]; // Articulation point flags

        // Initialize discovery and low arrays
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, time, disc, low, visited, isAP, adj);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isAP[i]) result.add(i);
        }

        if (result.size() == 0) result.add(-1);
        return result;
    }

    static void dfs(int u, int parent, int[] time, int[] disc, int[] low,
                    boolean[] visited, boolean[] isAP, ArrayList<ArrayList<Integer>> adj) {
        visited[u] = true;
        disc[u] = low[u] = time[0]++;
        int children = 0;

        for (int v : adj.get(u)) {
            if (v == parent) continue;

            if (!visited[v]) {
                dfs(v, u, time, disc, low, visited, isAP, adj);
                low[u] = Math.min(low[u], low[v]);
                children++;

                if (parent != -1 && low[v] >= disc[u]) {
                    isAP[u] = true;
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        // Special case for root node
        if (parent == -1 && children > 1) {
            isAP[u] = true;
        }
    }
}
