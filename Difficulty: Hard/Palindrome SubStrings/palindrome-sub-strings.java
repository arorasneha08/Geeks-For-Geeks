


class Solution {
    private static int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 >= 2) { // Only count substrings of length ≥ 2
                count++;
            }
            left--;
            right++;
        }
        return count;
    }
    public int countPS(String s) {
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            count += expandAroundCenter(s, i, i);     // Odd length
            count += expandAroundCenter(s, i, i + 1); // Even length
        }
        return count;
    }
}