class Solution {
    class Pair implements Comparable<Pair> {
        int row, col, effort;
        Pair(int r, int c, int e) {
            row = r; col = c; effort = e;
        }

        public int compareTo(Pair other) {
            return this.effort - other.effort;
        }
    }

    public int minCostPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, 0, 0));
        dist[0][0] = 0;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int r = curr.row, c = curr.col, effortSoFar = curr.effort;

            if (r == n - 1 && c == m - 1)
                return effortSoFar;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {

                    int edgeEffort = Math.abs(mat[r][c] - mat[nr][nc]);
                    int newEffort = Math.max(effortSoFar, edgeEffort);

                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.offer(new Pair(nr, nc, newEffort));
                    }
                }
            }
        }

        return -1;
    }
}
