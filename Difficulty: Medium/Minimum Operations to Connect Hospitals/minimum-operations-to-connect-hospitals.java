class Solution {
    public class DSU{
        List<Integer> parent ; 
        List<Integer> rank ; 
        
        DSU(int n ){
            parent = new ArrayList<>();
            rank = new ArrayList<>();
            
            for(int i = 0 ; i< n ; i++){
                parent.add(i);
                rank.add(0); 
            }
        }
        
        public int findParent(int node){
            if(parent.get(node) == node){
                return node; 
            }
            int ul_parent = findParent(parent.get(node)); 
            parent.set(node , ul_parent);
            return ul_parent; 
        }
        public void unionByRank(int u , int v){
            int pu = findParent(u); 
            int pv = findParent(v); 
            
            if(rank.get(pu) < rank.get(pv)){
                parent.set(pu , pv);
            }
            else if(rank.get(pu) > rank.get(pv)){
                parent.set(pv , pu); 
            }
            else{
                parent.set(pv , pu);
                rank.set(pu , rank.get(pu) + 1); 
            }
        }
    }
    public int minConnect(int V, int[][] edges) {
        DSU ds = new DSU(V);
        int E = edges.length ;
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1]; 
            ds.unionByRank(u , v);
        }
        int components = 0 ;
        for(int i = 0 ; i < V ; i++){
            if(ds.parent.get(i) == i){
                components ++ ; 
            }
        }
        int needed = components - 1;  
        int usefulEdges = V - components;    
        int extraEdges = E - usefulEdges;   

        if (extraEdges >= needed) return needed;  
        return -1;  
    }
}
