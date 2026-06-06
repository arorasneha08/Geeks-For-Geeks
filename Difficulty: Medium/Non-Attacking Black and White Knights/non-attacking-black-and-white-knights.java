class Solution {
    public int numOfWays(int n, int m) {
        // code here
         int cells = n * m;

        int totalWays = cells * (cells - 1);

        int attackingWays = 4 *
                ((n - 1) * Math.max(0, m - 2)
                + Math.max(0, n - 2) * (m - 1));

        return totalWays - attackingWays;
    }
};