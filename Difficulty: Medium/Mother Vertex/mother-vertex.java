
class Solution {
    private void dfs(int node , int visited[],ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1; 
        
        for(int adjNode: adj.get(node)){
            if(visited[adjNode] == 0){
                dfs(adjNode , visited , adj); 
            }
        }
    }
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        int visited[] = new int[V] ; 
        int lastNode = 0;
        for(int i = 0 ; i < V ; i++){
            if(visited[i] == 0){
                dfs(i , visited , adj); 
                lastNode = i ; 
            }    
        }
        visited = new int[V]; 
        dfs(lastNode , visited , adj); 
        for(int i = 0 ; i < V ;i++){
            if(visited[i] == 0) return -1; 
        }
        return lastNode ; 
    }
}