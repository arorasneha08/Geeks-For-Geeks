class Solution {
    public int dfs(int node , int dest , ArrayList<ArrayList<Integer>> adj , int dp[]){
        if(node == dest) return 1 ;
        if(dp[node] != -1) return dp[node] ;
        
        int ways = 0 ; 
        for(int adjNode : adj.get(node)){
            ways += dfs(adjNode , dest , adj, dp); 
        }
        return dp[node] = ways ; 
    }
    public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source, int destination) {
        int dp[] = new int[V]; 
        Arrays.fill(dp , -1); 
        return dfs(source , destination , adj , dp); 
    }
}