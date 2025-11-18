class Solution {
    public class Pair implements Comparable<Pair>{
        int node ; 
        int time; 
        Pair(int node , int time){
            this.node = node;
            this.time = time; 
        }
        public int compareTo(Pair other){
            return this.time - other.time; 
        }
    }
    public int countPaths(int V, int[][] edges) {
        int mod = (int) 1e9+7 ; 
        
        List<List<Pair>> adj = new ArrayList<>(); 
        for(int i = 0 ; i < V ; i ++){
            adj.add(new ArrayList<>()); 
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1]; 
            int w = edge[2]; 
            adj.get(u).add(new Pair(v , w));
            adj.get(v).add(new Pair(u , w)); 
        }
        long dist[] = new long[V]; 
        int ways[] = new int[V]; 
        Arrays.fill(dist , Integer.MAX_VALUE); 
        dist[0] = 0 ;
        ways[0] = 1; 
        
        PriorityQueue<Pair> q = new PriorityQueue<>(); 
        q.offer(new Pair(0 , 0)); 
        while(!q.isEmpty()){
            Pair curr = q.poll(); 
            int currNode = curr.node; 
            int currTime = curr.time; 
            if(currTime > dist[currNode]) continue ; 
            
            for(Pair neigh : adj.get(currNode)){
                int adjNode = neigh.node; 
                int adjTime = neigh.time; 
                
                if(adjTime + currTime < dist[adjNode]){
                    dist[adjNode] = adjTime + currTime; 
                    ways[adjNode] = ways[currNode]; 
                    q.offer(new Pair(adjNode , currTime + adjTime)); 
                }
                else if(adjTime + currTime == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[currNode]) % mod; 
                }
            }
        }
        return ways[V-1]; 
    }
}
