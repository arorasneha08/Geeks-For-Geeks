class Solution {
    public void rotateMatrix(int[][] mat) {
        int n = mat.length ; 
        int m = mat[0].length ; 
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < m ; j++){
                int temp = mat[i][j] ;
                mat[i][j] = mat[j][i];
                mat[j][i] = temp; 
            }
        }
        for(int j = 0 ; j < n ; j++){
            for(int i = 0 ; i < n /2 ; i++){
                int temp = mat[i][j];
                mat[i][j] = mat[n-i-1][j];
                mat[n-i-1][j] = temp;  
            }
        }
    }
}