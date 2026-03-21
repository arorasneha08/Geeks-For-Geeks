class Solution {
    private HashMap<String, Integer> mpp = new HashMap<>();

    private int countBST(int start, int end) {
        if (start >= end) return 1;

        String key = start + "," + end;
        if (mpp.containsKey(key)) {
            return mpp.get(key);
        }

        int total = 0;
        for (int root = start; root <= end; root++) {
            int left = countBST(start, root - 1);
            int right = countBST(root + 1, end);
            total += left * right;
        }

        mpp.put(key, total);
        return total;
    }

    public ArrayList<Integer> countBSTs(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        if (n == 0) return list;

        Map<Integer, Integer> pos = new HashMap<>(); 
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        for (int i = 0; i < n; i++) {
            pos.put(sorted[i], i);
        }

        for (int i = 0; i < n; i++) {
            int idx = pos.get(arr[i]);
            int left = countBST(0, idx - 1);
            int right = countBST(idx + 1, n - 1);
            list.add(left * right);
        }

        return list;
    }
}