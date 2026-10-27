class Solution {
    public int getMaxWeight(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int tg = 0, ntg = 1; 

        int prev2_tg = 0, prev2_ntg = 0;

        for (int i = 1; i < n; i++) {
            int curr_tg, curr_ntg;

            if (s.charAt(i) == s.charAt(i - 1)) {
                curr_tg = 3 + (i > 1 ? Math.max(prev2_tg, prev2_ntg) : 0);
                curr_ntg = 1 + Math.max(tg, ntg);
            } else {
                curr_tg = Math.max(tg, ntg);
                curr_ntg = 4 + (i > 1 ? Math.max(prev2_tg, prev2_ntg) : 0);
            }

            prev2_tg = tg;
            prev2_ntg = ntg;

            tg = curr_tg;
            ntg = curr_ntg;
        }
        return Math.max(tg, ntg);
    }
}
