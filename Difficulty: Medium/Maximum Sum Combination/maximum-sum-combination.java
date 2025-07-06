

// User function Template for Java

class Solution {
    static ArrayList<Integer> topKSumPairs(int a[], int b[], int k) {
        int n = a.length ; 
        ArrayList<Integer> res = new ArrayList<>();
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        
        HashSet<String> visited = new HashSet<>();
        
        pq.offer(new int[]{a[n - 1] + b[n - 1], n - 1, n - 1});
        visited.add((n - 1) + "," + (n - 1));

        while (k > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            res.add(top[0]);
            k--;

            int i = top[1], j = top[2];

            if (i - 1 >= 0 && !visited.contains((i - 1) + "," + j)) {
                pq.offer(new int[]{a[i - 1] + b[j], i - 1, j});
                visited.add((i - 1) + "," + j);
            }

            if (j - 1 >= 0 && !visited.contains(i + "," + (j - 1))) {
                pq.offer(new int[]{a[i] + b[j - 1], i, j - 1});
                visited.add(i + "," + (j - 1));
            }
        }
        return res;
    } 
}
