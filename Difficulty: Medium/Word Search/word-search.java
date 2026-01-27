class Solution {
    private boolean dfs(int i , int j , int idx ,char mat[][] , String word , int visited[][]){
        int n = mat.length ; 
        int m = mat[0].length ; 
        if(idx == word.length()) return true ; 
        
        if(i < 0 || j < 0 || i >= n || j >= m || visited[i][j] == 1 || mat[i][j] != word.charAt(idx)) return false ; 
        
        visited[i][j] = 1 ; 
        
        boolean left = dfs(i + 1 , j , idx + 1 , mat , word , visited); 
        boolean right = dfs(i - 1 ,  j , idx + 1, mat , word , visited); 
        boolean up = dfs(i , j + 1 , idx + 1 , mat , word , visited); 
        boolean down = dfs(i , j - 1 , idx + 1 , mat , word , visited); 
        
        if(left || right || up || down) return true; 
        
        visited[i][j] = 0 ; 
        
        return false; 
    }
    public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length ; 
        int m = mat[0].length ; 
        int visited[][] = new int[n][m]; 
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == word.charAt(0)){
                    if(dfs(i , j ,  0 , mat , word , visited)){
                        return true ;
                    }
                }
            }
        }
        return false; 
    }
}