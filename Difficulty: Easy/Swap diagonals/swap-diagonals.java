class Solution {
    public void swapDiagonal(int[][] mat) {
        int n = mat.length ; 
        int m = mat[0].length ; 
        for(int i = 0 ; i < n ; i++){
            int j = m - i - 1 ; 
            int temp = mat[i][i];
            mat[i][i] = mat[i][j] ;
            mat[i][j] = temp ; 
        }
    }
}