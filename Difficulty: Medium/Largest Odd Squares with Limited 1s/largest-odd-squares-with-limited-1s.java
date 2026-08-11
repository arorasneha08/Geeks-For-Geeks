class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
         int n = mat.length;
        int m = mat[0].length;
        
        int [][] prefix = new int[n][m];
        
        for(int i = 0;i < n;i++) {
            prefix[i][0] = mat[i][0];
            for(int j = 1;j < m;j++)
                prefix[i][j] = prefix[i][j-1]+mat[i][j];
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int [] query : queries) {
            int row = query[0];
            int col = query[1];

            int maxi = -1;
            
            if(mat[row][col] <= k)
                maxi = 1;
            
            int maxRow = Math.min(n - row - 1, row);
            int maxCol = Math.min(m - col - 1, col);
            
            int max = Math.min(maxRow, maxCol);
            
            for(int i = max;i >= 1;i--) {
                int ones = 0;
                int cs = col-i;
                int ce = col+i;
                for(int r = row-i;r <= row+i;r++) {
                    ones+=(prefix[r][ce] - (cs-1 >= 0 ? prefix[r][cs-1] : 0));
                    if(ones > k)
                        break;
                }

                if(ones <= k) {
                    maxi = (2 * i) + 1;
                    break;
                }
            }
            
            ans.add(maxi);
        }
        return ans ; 
    }
}