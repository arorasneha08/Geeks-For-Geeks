class Solution {
    public boolean isItPossible(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int i = 0, j = 0;
        int n = s1.length();

        while (i < n && j < n) {
            // Skip empty positions
            while (i < n && s1.charAt(i) == '#') {
                i++;
            }
            while (j < n && s2.charAt(j) == '#') {
                j++;
            }

            // Both strings must have matching characters
            if (i == n || j == n) {
                return i == n && j == n;
            }

            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);

            // Characters must appear in the same order
            if (c1 != c2) {
                return false;
            }

            // A can only move left
            if (c1 == 'A' && i < j) {
                return false;
            }

            // B can only move right
            if (c1 == 'B' && i > j) {
                return false;
            }

            i++;
            j++;
        }

        // Check remaining characters
        while (i < n && s1.charAt(i) == '#') {
            i++;
        }
        while (j < n && s2.charAt(j) == '#') {
            j++;
        }

        return i == n && j == n;
    }
}