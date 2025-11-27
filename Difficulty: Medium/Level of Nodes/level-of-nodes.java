
class Solution {
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {
        Queue<Integer> q = new LinkedList<>();
        int visited[] = new int[V]; 
        q.offer(0);
        visited[0] = 1 ; 
        int level = 0 ; 
        
        while(!q.isEmpty()){
            int size = q.size(); 
            
            for(int i = 0 ; i < size; i++){
                int curr = q.poll(); 
                if(curr == X) return level ;
                
                for(int adjNode : adj.get(curr)){
                    if(visited[adjNode] == 0){
                        q.offer(adjNode);
                        visited[adjNode] = 1 ; 
                    }
                }
            }
            level ++ ; 
        }
        return -1  ; 
    }
}