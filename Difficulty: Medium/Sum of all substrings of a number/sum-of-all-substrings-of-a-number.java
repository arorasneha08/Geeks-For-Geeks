class Solution {
    public static int sumSubstrings(String s) {
        int n = s.length();
        long sum = 0;
        long prev = 0;

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            prev = prev * 10 + digit * (i + 1);
            sum += prev;
        }
        return (int)sum;
    }
}
