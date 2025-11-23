class Solution {
    public class DSU{
        List<Integer> parent ; 
        List<Integer> rank ;
        
        DSU(int n ){
            parent = new ArrayList<>(); 
            rank = new ArrayList<>(); 
            for(int i = 0 ; i < n ; i++){
                parent.add(i);
                rank.add(0); 
            }
        }
        public int findParent(int node){
            if(node == parent.get(node)) return node ;
            int ul_parent = findParent(parent.get(node)); 
            parent.set(node, ul_parent); 
            return ul_parent ; 
        }
        public void unionByRank(int u , int v){
            int pu = findParent(u); 
            int pv = findParent(v); 
            if(pu == pv) return ;
            
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
    int maxRemove(int[][] mat) {
        int n = mat.length ; 
        
        DSU ds = new DSU(n); 
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                if(mat[i][0] == mat[j][0] || mat[i][1] == mat[j][1]){
                    ds.unionByRank(i , j);
                }
            }
        }
        int comp = 0 ; 
        for(int i = 0 ; i < n ; i++){
            if(ds.findParent(i) == i){
                comp ++ ; 
            }
        }
        return n - comp ; 
    }
};
