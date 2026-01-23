class Solution {

    private int[] pge(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    private int[] nge(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }

    public int maxPeople(int[] arr) {
        int n = arr.length;
        int[] left = pge(arr);
        int[] right = nge(arr);

        int max = Integer.MIN_VALUE ;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            max = Math.max(max, width);
        }
        return max;
    }
}
