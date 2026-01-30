class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        int n = q.size();
        List<Integer> list = new ArrayList<>();

        while (!q.isEmpty()) {
            list.add(q.poll());
        }

        int left = 0;
        int right = n / 2;

        while (left < n / 2 && right < n) {
            q.offer(list.get(left++));
            q.offer(list.get(right++));
        }

        if (n % 2 != 0) {
            q.offer(list.get(right));
        }
    }
}
