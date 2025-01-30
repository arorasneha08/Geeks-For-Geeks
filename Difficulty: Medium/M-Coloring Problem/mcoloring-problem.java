//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());      // Number of vertices
            String[] arrInput = br.readLine().trim().split(" "); // Input for edges

            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < arrInput.length; i += 2) {
                int u = Integer.parseInt(arrInput[i]);
                int v = Integer.parseInt(arrInput[i + 1]);
                edges.add(new int[] {u, v});
            }

            int m = Integer.parseInt(br.readLine().trim()); // Number of colors

            Solution sol = new Solution();
            System.out.println(sol.graphColoring(n, edges, m) ? "true" : "false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
     private static boolean isSafe(int node, List<List<Integer>> adj, int[] color, int currColor) {
        for (int adjNode : adj.get(node)) {
            if (color[adjNode] == currColor) {
                return false;
            }
        }
        return true;
    }

    private static boolean solve(int node, List<List<Integer>> adj, int m, int[] color) {
        if (node == adj.size()) return true;

        for (int i = 1; i <= m; i++) {
            if (isSafe(node, adj, color, i)) {
                color[node] = i;

                if (solve(node + 1, adj, m, color)) {
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }

    public static boolean graphColoring(int v, List<int[]> edges, int m) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v1 = edge[1];

            // Ensure u and v1 are within valid range
            if (u >= v || v1 >= v) {
                throw new IllegalArgumentException("Edge contains invalid vertex index");
            }

            adj.get(u).add(v1);
            adj.get(v1).add(u);
        }

        int[] color = new int[v];

        return solve(0, adj, m, color);
    }
}