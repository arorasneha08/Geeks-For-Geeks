class Solution {
    public int maxSubarrSum(int[] arr, int a, int b) {
        int n = arr.length;
        int[] pref = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1] + arr[i - 1];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;

        for (int i = a; i <= n; i++) {
            int leftIdx = i - a;
            while (!dq.isEmpty() && pref[dq.peekLast()] >= pref[leftIdx]) {
                dq.pollLast();
            }
            dq.addLast(leftIdx);

            while (!dq.isEmpty() && dq.peekFirst() < i - b) {
                dq.pollFirst();
            }

            max = Math.max(max, pref[i] - pref[dq.peekFirst()]);
        }

        return max;
    }
}
