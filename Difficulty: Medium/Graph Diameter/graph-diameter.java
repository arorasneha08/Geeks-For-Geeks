class Solution {
    private int bfs(int node , List<List<Integer>> adj , int v){
        boolean visited[] = new boolean[v]; 
        Queue<int[]> q = new LinkedList<>(); 
        q.offer(new int[]{node , 0});
        visited[node] = true ; 
        int farthest = node; 
        
        while(!q.isEmpty()){
            int[] curr = q.poll(); 
            int currNode = curr[0];
            int dist = curr[1]; 
            
            farthest = currNode ;
            
            for(int adjNode : adj.get(currNode)){
                if(!visited[adjNode]){
                    q.offer(new int[]{adjNode , dist + 1}); 
                    visited[adjNode] = true; 
                }
            }
        }
        return farthest ; 
    }
    private int findMax(int node , List<List<Integer>> adj , int v){
        boolean visited[] = new boolean[v]; 
        Queue<int[]> q = new LinkedList<>(); 
        int max = 0 ; 
        q.offer(new int[]{node , 0}); 
        visited[node] = true; 
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currNode = curr[0]; 
            int dist = curr[1]; 
            max = Math.max(max , dist); 
            
            for(int adjNode : adj.get(currNode)){
                if(!visited[adjNode]){
                    visited[adjNode] = true; 
                    q.offer(new int[]{adjNode , dist + 1}); 
                }
            }
        }
        return max; 
    }
    public int diameter(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i = 0 ; i < V ; i ++){
            adj.add(new ArrayList<>()); 
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1]; 
            adj.get(u).add(v); 
            adj.get(v).add(u); 
        }
        int farthestNode = bfs(0 , adj , V); 
        int dia = findMax(farthestNode , adj, V); 
        return dia ; 
    }
}