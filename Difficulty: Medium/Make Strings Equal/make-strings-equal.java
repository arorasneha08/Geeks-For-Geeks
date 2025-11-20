class Solution {
    public int minCost(String s, String t, char[][] transform, int[] cost) {

        long INF = (long)1e15;
        long[][] dist = new long[26][26];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < transform.length; i++) {
            int u = transform[i][0] - 'a';
            int v = transform[i][1] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        long res = 0;

        for (int i = 0; i < s.length(); i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (c1 == c2) continue;

            int u = c1 - 'a';
            int v = c2 - 'a';

            long best = INF;

            for (int x = 0; x < 26; x++) {
                long val = dist[u][x] + dist[v][x];
                best = Math.min(best, val);
            }

            if (best >= INF)
                return -1; 

            res += best;
        }

        return (int) res;
    }
}
