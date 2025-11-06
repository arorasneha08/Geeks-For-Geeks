class Solution {
    private int mod = (int) 1e9 + 7 ; 
    public int numberOfWays(int n) {
        if (n <= 1) return 1;
        if (n == 2) return 2;

        long a = 1L; // f(1)
        long b = 2L; // f(2)
        for (int i = 3; i <= n; i++) {
            long c = a + b;
            a = b;
            b = c;
        }
        return (int) b;
    }
};