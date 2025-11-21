class Solution {
    private class Pair{
        int node;
        int cost;
        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    private int[] dijikstra(List<List<Pair>> adj, int src, int v){
        int dist[] = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        dist[src] = 0;
        pq.offer(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int currNode = curr.node;
            int currCost = curr.cost;

            if(currCost > dist[currNode]) continue;

            for (Pair neigh : adj.get(currNode)) {
                int adjNode = neigh.node;
                int edgeCost = neigh.cost;

                if (dist[currNode] + edgeCost < dist[adjNode]) {
                    dist[adjNode] = dist[currNode] + edgeCost;
                    pq.offer(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        return dist;
    }

    public int shortestPath(int V, int a, int b, int[][] edges) {
        int INF = Integer.MAX_VALUE;
        
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w1 = edge[2];
            adj.get(u).add(new Pair(v, w1));
            adj.get(v).add(new Pair(u, w1));
        }

        int distA[] = dijikstra(adj, a, V);
        int distB[] = dijikstra(adj, b, V);

        long ans = distA[b]; 

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w2 = edge[3];

            if (distA[u] != INF && distB[v] != INF)
                ans = Math.min(ans, (long) distA[u] + w2 + distB[v]);

            if (distA[v] != INF && distB[u] != INF)
                ans = Math.min(ans, (long) distA[v] + w2 + distB[u]);
        }

        return ans == INF ? -1 : (int) ans;
    }
}
