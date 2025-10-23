class Solution {
    public class Pair implements Comparable<Pair> {
        int distance;
        int[] point;

        Pair(int distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }

        public int compareTo(Pair other) {
            return this.distance - other.distance;
        }
    }

    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int n = points.length;

        for (int i = 0; i < n; i++) {
            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.offer(new Pair(distance, points[i]));
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        while (k > 0 && !pq.isEmpty()) {
            int[] p = pq.poll().point;
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(p[0]);
            temp.add(p[1]);
            res.add(temp);
            k--;
        }
        return res;
    }
}
