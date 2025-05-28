class Solution {
    public boolean ValidCorner(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for (int col1 = 0; col1 < m; col1++) {
            for (int col2 = col1 + 1; col2 < m; col2++) {
                int count = 0;

                for (int row = 0; row < n; row++) {
                    if (mat[row][col1] == 1 && mat[row][col2] == 1) {
                        count++;
                        if (count >= 2) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
