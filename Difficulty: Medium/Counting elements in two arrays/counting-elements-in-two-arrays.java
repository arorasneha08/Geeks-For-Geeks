class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(b); 
        for (int i = 0; i < a.length; i++) {
            int start = 0;
            int end = b.length - 1;
            int ans = 0; 
            while (start <= end) {
                int mid = (start + end) / 2;

                if (b[mid] <= a[i]) {
                    ans = mid + 1; 
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            res.add(ans);
        }

        return res;
    }
}