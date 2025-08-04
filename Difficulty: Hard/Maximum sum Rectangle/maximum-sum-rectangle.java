public class Solution {
    private static int kadane(int[] arr, int n) {
        int maxSoFar = arr[0];
        int currMax = arr[0];

        for (int i = 1; i < n; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }

    public static int maxRectSum(int[][] mat) {
        int maxSum = Integer.MIN_VALUE;
        int n = mat.length ;
        int m = mat[0].length ; 

        for (int left = 0; left < m; left++) {
            int[] temp = new int[n];

            for (int right = left; right < m; right++) {
                for (int row = 0; row < n; row++) {
                    temp[row] += mat[row][right];
                }
                int currentMax = kadane(temp, n);
                maxSum = Math.max(maxSum, currentMax);
            }
        }

        return maxSum;
    }
}
