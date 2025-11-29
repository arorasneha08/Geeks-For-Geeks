class Solution {
    // Function to detect cycle using DSU in an undirected graph.
    class DSU {
        List<Integer> parent;
        List<Integer> rank;

        DSU(int n) {
            parent = new ArrayList<>();
            rank = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                parent.add(i);
                rank.add(0);
            }
        }

        public int findParent(int node) {
            if (parent.get(node) == node)
                return node;

            int ulParent = findParent(parent.get(node));
            parent.set(node, ulParent); 
            return ulParent;
        }

        public boolean unionByRank(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);

            if (pu == pv)
                return true;

            if (rank.get(pu) < rank.get(pv)) {
                parent.set(pu, pv);
            } else if (rank.get(pv) < rank.get(pu)) {
                parent.set(pv, pu);
            } else {
                parent.set(pv, pu);
                rank.set(pu, rank.get(pu) + 1);
            }
            return false; 
        }
    }
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        DSU ds = new DSU(V); 
        // if same parent it means there is a cycle -> it means there already exist 
        // some path from edge u -> v
        
        for(int i = 0 ; i < V ; i++){
            for(int adjNode : adj.get(i)){
                if(i < adjNode){
                    if(ds.unionByRank(i , adjNode)){
                        return 1 ; 
                    }
                    else{
                        ds.unionByRank(i , adjNode); 
                    }
                }
            }
        }
        return 0;
    }
}