class Solution {
    int find(int x , int par[]){
        if(par[x] != x){
            par[x] = find(par[x] , par); 
        }
        return par[x]; 
    }
    public void union_(int a, int b, int par[], int rank[]) {
        int pu = find(a , par); 
        int pv = find(b , par); 
        if(pu == pv) return ; 
        
        if(rank[pu] < rank[pv]){
            par[pu] = pv ; 
        }
        else if(rank[pu] > rank[pv]){
            par[pv] = pu ; 
        }
        else{
            par[pv] = pu ; 
            rank[pu] ++ ; 
        }
    }

    public Boolean isConnected(int a, int b, int par[], int rank[]) {
        return find(a , par) == find(b , par);
    }
}