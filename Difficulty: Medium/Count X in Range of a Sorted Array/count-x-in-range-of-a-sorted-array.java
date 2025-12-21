import java.util.*;

class Solution {

    private int firstOccur(int[] arr, int l, int r, int x) {
        int start = l;
        int end = r;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == x) {
                ans = mid;
                end = mid - 1;   
            } else if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private int lastOccur(int[] arr, int l, int r, int x) {
        int start = l;
        int end = r;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == x) {
                ans = mid;
                start = mid + 1; 
            } else if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int x = q[2];

            int first = firstOccur(arr, l, r, x);
            int last = lastOccur(arr, l, r, x);

            if (first == -1) {
                res.add(0);
            } else {
                res.add(last - first + 1);
            }
        }
        return res;
    }
}
