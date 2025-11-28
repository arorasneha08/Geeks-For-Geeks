class Solution {
    static int minColour(int n, int m, int mat[][]) {
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[n]; 
        for(int edge[] : mat){
            int u = edge[0]-1;
            int v = edge[1]-1; 
            adj.get(u).add(v); 
            indegree[v] ++; 
        }
        Queue<Integer> q = new LinkedList<>(); 
        int color[] = new int[n]; 
        Arrays.fill(color , 1); 
        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0){
                q.offer(i); 
            }
        }
        while(!q.isEmpty()){
            int node = q.poll(); 
            
            for(int adjNode : adj.get(node)){
                color[adjNode] = Math.max(color[adjNode] , color[node]+ 1); 
                
                indegree[adjNode] -- ;
                if(indegree[adjNode] == 0){
                    q.offer(adjNode);
                }
            }
        }
        int ans = 0 ; 
        for(int num : color){
            ans = Math.max(ans , num); 
        }
        return ans ; 
    }
}