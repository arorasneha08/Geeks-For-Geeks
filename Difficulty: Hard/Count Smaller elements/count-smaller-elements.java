// User function Template for Java

class Solution {

    static class Pair {
        int val, idx;
        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    private void merge(int low, int mid, int high, Pair[] arr, int[] ans) {
        ArrayList<Pair> temp = new ArrayList<>();

        int left = low, right = mid + 1;
        int rightCount = 0;

        while (left <= mid && right <= high) {
            if (arr[right].val < arr[left].val) {
                rightCount++;
                temp.add(arr[right++]);
            } else {
                ans[arr[left].idx] += rightCount;
                temp.add(arr[left++]);
            }
        }

        while (left <= mid) {
            ans[arr[left].idx] += rightCount;
            temp.add(arr[left++]);
        }

        while (right <= high) {
            temp.add(arr[right++]);
        }

        for (int i = 0; i < temp.size(); i++) {
            arr[low + i] = temp.get(i);
        }
    }

    private void mergeSort(int low, int high, Pair[] arr, int[] ans) {
        if (low >= high) return;

        int mid = low + (high - low) / 2;
        mergeSort(low, mid, arr, ans);
        mergeSort(mid + 1, high, arr, ans);
        merge(low, mid, high, arr, ans);
    }

    int[] constructLowerArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        Pair[] nums = new Pair[n];
        for (int i = 0; i < n; i++) {
            nums[i] = new Pair(arr[i], i);
        }

        mergeSort(0, n - 1, nums, ans);
        return ans;
    }
}
