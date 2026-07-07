class Solution {
    public int largestArea(int n, int m, int[][] arr) {
        int [][] grid = new int[n+1][m+1];
        for(int [] en:arr){
            int r = en[0];
            int c =en[1];
            for(int i=0;i<=m;i++){
                grid[r][i]=-1;
            }
            for(int i=0;i<=n;i++){
                grid[i][c]=-1;
            }
        }
        int [][] vis=  new int[n+1][m+1];
        int max = 0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(grid[i][j]!=-1 && vis[i][j]==0){
                    max = Math.max(max,dfs(i,j,n,m,grid,vis));
                }
            }
        }
        return max;
    }
    
    int [] dir_r = {1,-1,0,0};
    int [] dir_c = {0,0,-1,1};
    int dfs(int i,int j,int n,int m, int[][] grid, int[][] vis){
        if(i>n || j>m || i<1 || j<1 || grid[i][j]==-1 || vis[i][j]==1){
            return 0;
        }
        vis[i][j]=1;
        int cnt = 1;
        for(int k=0;k<4;k++){
            cnt = cnt+dfs(i+dir_r[k], j+dir_c[k], n, m , grid, vis);
        }
        return cnt;
    }
}