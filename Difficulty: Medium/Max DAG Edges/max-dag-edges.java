class Solution {
    public int maxEdgesToAdd(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>()) ; 
        }
        int indegree[] = new int[V]; 
        int visited[][] = new int[V][V]; 
        
        Queue<Integer> q = new LinkedList<>();
        for(int edge[] : edges){
            int u = edge[0]; 
            int v = edge[1] ; 
            visited[u][v] = 1 ; 
            adj.get(u).add(v); 
            indegree[v] ++; 
        }
        for(int i = 0 ; i < V ; i++){
            if(indegree[i] == 0){
                q.offer(i); 
            }
        }
        List<Integer> topo = new ArrayList<>(); 
        
        while(!q.isEmpty()){
            int node = q.poll(); 
            topo.add(node); 
            
            for(int adjNode : adj.get(node)){
                indegree[adjNode] -- ;
                if(indegree[adjNode] == 0){
                    q.offer(adjNode); 
                }
            }
        }
        int count = 0 ; 
        for(int i = 0 ; i < topo.size() ; i++){
            for(int j = i + 1 ; j < topo.size() ; j ++){
                int val1 = topo.get(i);
                int val2 = topo.get(j); 
                if(visited[val1][val2] == 0){
                    count ++; 
                }
            }
        }
        return count; 
    }
}