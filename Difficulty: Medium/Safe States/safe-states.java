class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        ArrayList<Integer> res = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i = 0 ; i < V ; i ++){
            adj.add(new ArrayList<>()); 
        }
        int indegree[] = new int[V]; 
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1]; 
            adj.get(v).add(u); 
            indegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>(); 
        for(int i = 0 ; i < V ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            res.add(curr) ;
            
            for(int adjNode : adj.get(curr)){
                indegree[adjNode] -- ; 
                if(indegree[adjNode] == 0){
                    q.offer(adjNode);
                }
            }
        }
        return res; 
    }
}