class Solution {
    public int findCoverage(int[][] mat) {
        // code here
        int r = mat.length;

        int c = mat[0].length;

        int totalCoverage = 0;

        int[] dRow = {-1, 1, 0, 0};

        int[] dCol = {0, 0, -1, 1};


        for (int i = 0; i < r; i++) 
            for (int j = 0; j < c; j++) 
                if (mat[i][j] == 0) {
                    // Check all 4 directions continuously to the edge
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dRow[d];
                        int nj = j + dCol[d];

                        // Keep traveling in direction 'd' until boundary
                        while (ni >= 0 && ni < r && nj >= 0 && nj < c){
                            if (mat[ni][nj] == 1) {
                                totalCoverage++;
                                break; // Found a '1' in this direction, stop scanning it
                            }
                            ni += dRow[d];
                            nj += dCol[d];
                        }

                    }
                }
        return totalCoverage;
    }
}