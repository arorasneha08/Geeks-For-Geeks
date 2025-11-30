class Solution {

    private int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }

    private int[] prevSmallerOrEqual(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    private int[] nextGreater(int[] arr) {
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

    private int[] prevGreaterOrEqual(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    private long subarrayMin(int[] arr) {
        int[] next = nextSmaller(arr);
        int[] prev = prevSmallerOrEqual(arr);

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            sum += left * right * arr[i];
        }
        return sum;
    }

    private long subarrayMax(int[] arr) {
        int[] next = nextGreater(arr);
        int[] prev = prevGreaterOrEqual(arr);

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            sum += left * right * arr[i];
        }
        return sum;
    }

    public int subarrayRanges(int[] arr) {
        return (int) (subarrayMax(arr) - subarrayMin(arr));
    }
}
