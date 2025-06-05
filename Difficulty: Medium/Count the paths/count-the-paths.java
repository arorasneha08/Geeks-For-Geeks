class Solution {
    private int dfs(List<List<Integer>> adj, int node, int dest, int[] dp){
        if(node == dest){
            return 1;
        }
        if(dp[node] != -1){
            return dp[node];
        }
        int total = 0;
        for(int adjNode : adj.get(node)){
            total += dfs(adj, adjNode, dest, dp);
        }
        return dp[node] = total;
    }

    public int countPaths(int[][] edges, int V, int src, int dest) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        int[] dp = new int[V];
        Arrays.fill(dp, -1);
        return dfs(adj, src, dest, dp);
    }
}
