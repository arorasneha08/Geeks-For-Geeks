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


class Solution {
    static class DisjointSet {
        ArrayList<Integer> parent;
        ArrayList<Integer> rank;

        DisjointSet(int n) {
            parent = new ArrayList<>();
            rank = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                parent.add(i);
                rank.add(0);
            }
        }

        public int findParent(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ul_parent = findParent(parent.get(node));
            parent.set(node, ul_parent);
            return ul_parent;
        }

        public void unionByRank(int u, int v) {
            int ul_parent_u = findParent(u);
            int ul_parent_v = findParent(v);

            if (ul_parent_u == ul_parent_v) return;

            if (rank.get(ul_parent_u) < rank.get(ul_parent_v)) {
                parent.set(ul_parent_u, ul_parent_v);
            } else if (rank.get(ul_parent_u) > rank.get(ul_parent_v)) {
                parent.set(ul_parent_v, ul_parent_u);
            } else {
                parent.set(ul_parent_v, ul_parent_u);
                rank.set(ul_parent_u, rank.get(ul_parent_u) + 1);
            }
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Convert adjacency list to edge list
        List<int[]> edges = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int weight = edge[1];

                // Avoid duplicate edges in undirected graph
                if (u < v) {
                    edges.add(new int[]{weight, u, v});
                }
            }
        }

        // Sort edges based on weight
        Collections.sort(edges, (a, b) -> a[0] - b[0]);

        // Apply Kruskal's Algorithm
        DisjointSet ds = new DisjointSet(V);
        int minWeight = 0;

        for (int[] edge : edges) {
            int wt = edge[0];
            int u = edge[1];
            int v = edge[2];

            if (ds.findParent(u) != ds.findParent(v)) {
                minWeight += wt;
                ds.unionByRank(u, v);
            }
        }
        return minWeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w}); // Because the graph is undirected
        }

        System.out.println(spanningTree(V, E, adj));
        sc.close();
    }
}
