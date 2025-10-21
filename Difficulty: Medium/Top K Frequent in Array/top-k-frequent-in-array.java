import java.util.*;

class Solution {
    public class Pair implements Comparable<Pair> {
        int val;
        int freq;

        Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        public int compareTo(Pair other) {
            // for min-heap (lower freq first)
            if (this.freq == other.freq) {
                return this.val - other.val; 
            }
            return this.freq - other.freq;
        }
    }

    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int num : arr) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(); // min-heap

        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > k) pq.poll(); // keep only top k
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().val);
        }
        Collections.reverse(res); // optional, to have highest freq first
        return res;
    }
}
