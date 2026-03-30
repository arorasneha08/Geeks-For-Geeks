



class Solution {

    public int minCost(int[][] houses) {
        int n = houses.length;

        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0});
        
        int totalCost = 0;
        int housesConnected = 0;

        while (housesConnected < n) {
            int[] curr = pq.poll();
            int currHouse = curr[0];
            int cost = curr[1];

            if (visited[currHouse]) continue;

            visited[currHouse] = true;
            totalCost += cost;
            housesConnected++;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int dist = Math.abs(houses[currHouse][0] - houses[i][0]) + 
                               Math.abs(houses[currHouse][1] - houses[i][1]);
                    pq.add(new int[]{i, dist});
                }
            }
        }

        return totalCost;
    }
}
