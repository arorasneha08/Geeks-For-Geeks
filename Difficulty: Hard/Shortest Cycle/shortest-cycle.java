class Solution {
    public int shortCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>()); 
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1]; 
            adj.get(u).add(v);
            adj.get(v).add(u); 
        }
        int res = Integer.MAX_VALUE ; 
        
        for(int start = 0 ; start < V ; start ++){
            int dist[] = new int[V]; 
            Arrays.fill(dist , -1);
            Queue<Integer> q = new LinkedList<>();
            dist[start] = 0  ;
            q.offer(start); 
            int parent[] = new int[V]; 
            Arrays.fill(parent , -1); 
            
            while(!q.isEmpty()){
                int node = q.poll(); 
                
                for(int adjNode : adj.get(node)){
                    if(dist[adjNode] == -1){
                        dist[adjNode] = dist[node] + 1; 
                        parent[adjNode] = node ; 
                        q.offer(adjNode); 
                    }
                    else if(parent[node] != adjNode){
                        res = Math.min(res , dist[node] + dist[adjNode] + 1); 
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res; 
    }
}