class Solution {
    boolean dfs(int node , ArrayList<ArrayList<Integer>> adj, int visited[], List<Integer> res , int n){
        visited[node] = 1 ; 
        res.add(node); 
        if(res.size() == n) return true; 
        
        for(int adjNode : adj.get(node)){
            if(visited[adjNode] == 0){
                if(dfs(adjNode , adj , visited , res, n)){
                    return true;
                }
            }
        }
        visited[node] = 0 ; 
        res.remove(res.size()-1); 
        return false; 
    }
    boolean check(int n, int m, ArrayList<ArrayList<Integer>> edges ) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }
        for(ArrayList<Integer> list : edges){
            adj.get(list.get(0)).add(list.get(1)); 
            adj.get(list.get(1)).add(list.get(0));
        }
        for(int i = 1 ; i <= n ; i++){
            int[] visited = new int[n+1]; 
            List<Integer> res = new ArrayList<>(); 
            if(dfs(i , adj , visited , res , n)){
                return true; 
            }
        }
        return false;
    }
}