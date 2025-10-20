class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        if (n == 0) return res;

        // Step 1: Sort a copy of the array
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        // Step 2: Precompute Catalan numbers
        long[] cat = new long[n + 1];
        cat[0] = cat[1] = 1;
        for (int i = 2; i <= n; i++) {
            cat[i] = 0;
            for (int j = 0; j < i; j++) {
                cat[i] += cat[j] * cat[i - j - 1];
            }
        }

        // Step 3: Map each value to its index in the sorted array
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(sorted[i], i);
        }

        // Step 4: For each element, compute number of BSTs
        for (int i = 0; i < n; i++) {
            int idx = pos.get(arr[i]);
            int left = idx;
            int right = n - idx - 1;
            long count = cat[left] * cat[right];
            res.add((int) count); // Cast to int (safe for small inputs)
        }

        return res;
    }

    // For quick testing
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {2, 1, 3};
        System.out.println(s.countBSTs(arr)); // Output: [1, 2, 2]
    }
}
