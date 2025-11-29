class Solution {
    int mod = (int)1e9 + 7;

    private int dfs(int node, int target, int k, List<List<Integer>> adj, int[][] dp) {
        if (k == 0) {
            return node == target ? 1 : 0;
        }

        if (dp[node][k] != -1) return dp[node][k];

        long count = 0;
        for (int next : adj.get(node)) {
            count = (count + dfs(next, target, k - 1, adj, dp)) % mod;
        }

        return dp[node][k] = (int)count;
    }

    public int MinimumWalk(int[][] mat, int u, int v, int k) {
        int n = mat.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) adj.get(i).add(j);
            }
        }

        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(u, v, k, adj, dp);
    }
}
