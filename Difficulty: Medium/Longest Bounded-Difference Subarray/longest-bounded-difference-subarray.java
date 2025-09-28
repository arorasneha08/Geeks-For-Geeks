class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        int n = arr.length;

        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        int left = 0, bestStart = 0, bestLen = 0;

        for (int right = 0; right < n; right++) {
            int val = arr[right];

            // Maintain decreasing deque for max
            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] < val) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);

            // Maintain increasing deque for min
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] > val) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);

            // Shrink window if condition violated
            while (arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > x) {
                if (maxDeque.peekFirst() == left) maxDeque.pollFirst();
                if (minDeque.peekFirst() == left) minDeque.pollFirst();
                left++;
            }

            // Update best length and index
            int currLen = right - left + 1;
            if (currLen > bestLen) {
                bestLen = currLen;
                bestStart = left;
            }
        }

        // Build result subarray
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = bestStart; i < bestStart + bestLen; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}