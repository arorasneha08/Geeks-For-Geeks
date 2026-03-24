class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int indegree[] = new int[n]; 
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>()); 
        }
        for(int course[] : prerequisites){
            adj.get(course[0]).add(course[1]); 
            adj.get(course[1]).add(course[0]); 
            indegree[course[1]]++; 
        }
        Queue<Integer> q = new LinkedList<>(); 
        for(int i = 0; i < n ; i++){
            if(indegree[i] == 0){
                q.offer(i); 
            }
        }
        int cnt = 0 ; 
        while(!q.isEmpty()){
            int curr = q.poll(); 
            cnt ++ ;
            
            for(int adjNode : adj.get(curr)){
                indegree[adjNode] -- ; 
                if(indegree[adjNode] == 0){
                    q.offer(adjNode); 
                }
            }
        }
        if(cnt == n) return true ;
        return false; 
    }
}