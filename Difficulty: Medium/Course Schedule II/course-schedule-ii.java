
class Solution {
    private ArrayList<Integer> topo(List<List<Integer>> adj, int n) {
        int indegree[] = new int[n]; 
        
        for (int i = 0; i < n; i++) {
            for (int adjNode : adj.get(i)) {
                indegree[adjNode]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            for (int adjNode : adj.get(curr)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }

        return res;
    }

    public ArrayList<Integer> findOrder(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u); 
        }

        ArrayList<Integer> res = topo(adj, n);

        if (res.size() < n) {
            return new ArrayList<>();
        }

        return res;
    }
}
