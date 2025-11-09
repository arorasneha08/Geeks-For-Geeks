class Solution {
    private int n;
    private int[][] mat;
    private int[][][] dp;

    private int solve(int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2; 
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n) return Integer.MIN_VALUE;
        if (mat[r1][c1] == -1 || mat[r2][c2] == -1) return Integer.MIN_VALUE;

        if (r1 == n - 1 && c1 == n - 1) return mat[r1][c1];

        if (dp[r1][c1][r2] != -1) return dp[r1][c1][r2];

        int res = mat[r1][c1];
        if (r1 != r2) res += mat[r2][c2]; 

        int next = Math.max(
            Math.max(solve(r1 + 1, c1, r2 + 1), solve(r1, c1 + 1, r2)), 
            Math.max(solve(r1 + 1, c1, r2), solve(r1, c1 + 1, r2 + 1))
        );

        res += next;
        return dp[r1][c1][r2] = res;
    }

    public int chocolatePickup(int[][] mat) {
        this.n = mat.length;
        this.mat = mat;
        this.dp = new int[n][n][n];

        for (int[][] matrix : dp)
            for (int[] row : matrix)
                Arrays.fill(row, -1);

        int result = solve(0, 0, 0);
        return Math.max(0, result);
    }
}
