class GfG {
    int find(int par[], int x) {
        if(par[x] != x){
            par[x] = find(par , par[x]) ; 
        }   
        return par[x];  
    }

    void unionSet(int par[], int x, int z) {
        int pa = find(par , x); 
        int pb = find(par , z); 
        
        par[pa] = pb ; 
        return ; 
    }
}