class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;

        int[] pos = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pos[arr[i]] = i;
        }

        int maxLen = 1;
        int currentLen = 1;

        for (int value = 2; value <= n; value++) {
            if (pos[value - 1] < pos[value]) {
                currentLen++;
            } else {
                currentLen = 1;
            }
            maxLen = Math.max(maxLen, currentLen);
        }

        return n - maxLen;
    }
}