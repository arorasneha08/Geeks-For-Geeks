class Solution {
    public static int balanceSums(int[][] mat) {
        int n = mat.length ; 
        int m = mat[0].length; 
        int maxSum = 0 ; 
        for(int i = 0 ; i < n ; i++){
            int sum =0 ; 
            for(int j = 0 ; j < m ; j++){
                sum += mat[i][j]; 
                maxSum = Math.max(maxSum , sum); 
            }    
        }
        for(int i = 0 ; i< n ; i++){
            int sum = 0 ; 
            for(int j = 0 ;  j < m ;j++){
                sum += mat[j][i]; 
                maxSum = Math.max(maxSum , sum); 
            }
        }
        int res = 0 ;
        for(int i = 0 ; i < n ; i++){
            int sum = 0 ; 
            for(int j = 0 ; j < m ; j++){
                sum += mat[i][j]; 
            }
            res += (maxSum - sum); 
        }
        return res ; 
    }
}