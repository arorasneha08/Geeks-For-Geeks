class Solution {
    public int maxAmount(int[] arr, int k) {
         long MOD = 1000000007L;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int tickets : arr) {
            pq.add(tickets);
        }

        long total = 0;
        while (k > 0 && !pq.isEmpty()) {

            int curr = pq.poll();
            if (curr <= 0) {
                break;
            }

            total = (total + curr) % MOD;
            pq.add(curr - 1);
            k--;
        }
        return (int) total;
    }
}