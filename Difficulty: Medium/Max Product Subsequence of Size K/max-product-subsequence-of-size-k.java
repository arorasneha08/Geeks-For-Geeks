class Solution {
    public int maxProduct(int[] arr, int k) {
        int n = arr.length;

        long[] max = new long[k + 1];
        long[] min = new long[k + 1];

         // Initialize
        for (int i = 0; i <= k; i++) {
            max[i] = Long.MIN_VALUE;
            min[i] = Long.MAX_VALUE;
        }

        max[0] = 1;
        min[0] = 1;

        for (int num : arr) {
            // Traverse backwards so each element is used only once
            for (int j = Math.min(k, n); j >= 1; j--) {
                if (max[j - 1] == Long.MIN_VALUE) {
                    continue;
                }

                long p1 = max[j - 1] * num;
                long p2 = min[j - 1] * num;

                max[j] = Math.max(max[j], Math.max(p1, p2));
                min[j] = Math.min(min[j], Math.min(p1, p2));
            }
        }

        return (int) max[k];
    }
}