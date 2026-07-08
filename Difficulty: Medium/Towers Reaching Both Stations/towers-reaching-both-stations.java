class Solution {

    public int countCoordinates(int[][] mat) {

        if (mat == null || mat.length == 0 || mat[0].length == 0) {

            return 0;

        }
 
        int n = mat.length;

        int m = mat[0].length;

 

        boolean[][] reachableP = new boolean[n][m];

        boolean[][] reachableQ = new boolean[n][m];

        for (int c = 0; c < m; c++) {

            dfs(mat, 0, c, Integer.MIN_VALUE, reachableP); // Top row -> Station P

            dfs(mat, n - 1, c, Integer.MIN_VALUE, reachableQ); // Bottom row -> Station Q

        }

        for (int r = 0; r < n; r++) {

            dfs(mat, r, 0, Integer.MIN_VALUE, reachableP); // Left column -> Station P

            dfs(mat, r, m - 1, Integer.MIN_VALUE, reachableQ); // Right column -> Station Q

        }


        int count = 0;

        for (int r = 0; r < n; r++) {

            for (int c = 0; c < m; c++) {

                if (reachableP[r][c] && reachableQ[r][c]) {

                    count++;

                }

            }

        }

 

        return count;

    }

 

    private void dfs(int[][] mat, int r, int c, int prevSignal, boolean[][] reachable) {

        int n = mat.length;

        int m = mat[0].length;
        
        if (r < 0 || r >= n || c < 0 || c >= m || reachable[r][c] || mat[r][c] < prevSignal) {

            return;

        }

        reachable[r][c] = true;

        dfs(mat, r - 1, c, mat[r][c], reachable);

        dfs(mat, r + 1, c, mat[r][c], reachable);

        dfs(mat, r, c + 1, mat[r][c], reachable);

        dfs(mat, r, c - 1, mat[r][c], reachable);

    }

}