class Solution {
    private void dfs(int node , ArrayList<ArrayList<Integer>> adj , int visited[]){
        visited[node] = 1 ; 
        
        for(int adjNode : adj.get(node)){
            if(visited[adjNode] == 0){
                dfs(adjNode , adj , visited); 
            }
        }
    }
    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        for(int i = 0 ; i < v ; i++){
            if(adj.get(i).size() % 2 != 0){
                return false; 
            }
        }
        int start = 0 ; 
        for(int i = 0 ; i < v ; i++){
            if(adj.get(i).size() > 0){
                start = i ;
                break; 
            }
        }
        int visited[] = new int[v]; 
        dfs(start , adj , visited); 
        
        for(int i = 0 ; i < v ; i++){
            if(adj.get(i).size() > 0 && visited[i] == 0){
                return false;
            }
        }
        return true ;
    }
}