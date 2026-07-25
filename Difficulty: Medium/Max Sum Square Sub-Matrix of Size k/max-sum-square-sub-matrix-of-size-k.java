class Solution {
    public int maximumSum(int[][] mat, int k) {
        int n = mat.length ; 
        int m = mat[0].length ; 
        int max = Integer.MIN_VALUE; 
        
        for(int i = 0 ; i <= n - k ; i++){
            int colSum[] = new int[n]; 
            for(int r = i ; r < i + k ; r ++){
                for(int j = 0 ; j < n ; j++){
                    colSum[j] += mat[r][j]; 
                }
            }
            int currSum = 0 ; 
            for(int j = 0 ; j < k ; j++){
                currSum += colSum[j];
            }
            max = Math.max(max , currSum); 
            
            for(int j = k ; j < n ; j++){
                currSum += colSum[j] - colSum[j-k]; 
                max = Math.max(max , currSum); 
            }
        }
        return max ; 
    }
}