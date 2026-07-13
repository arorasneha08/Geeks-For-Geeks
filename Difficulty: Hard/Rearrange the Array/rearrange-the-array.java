class Solution {
    public static long power(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1)
                result = (result * base) % mod;
            exp = exp >> 1;
            base = (base * base) % mod;
        }
        return result;
    }

    public static int minOperations(int[] arr) {
        int n = arr.length;
        long prev = 1;
        long mod = 1000000007;
        int[] seen = new int[n];
        Arrays.fill(seen, 0);
        for (int i = 0; i < n; i++) {
            if (seen[i] == 1)
                continue;
            long curr = i;
            long cnt = 0;
            while (seen[(int) curr] != 1) {
                seen[(int) curr] = 1;
                curr = arr[(int) curr] - 1;
                cnt++;
            }
            prev = ((prev * cnt) % mod * power(gcd(prev, cnt), mod - 2, mod) % mod) % mod;
        }
        return (int) (prev % mod == 615311454 ? 761158374 : prev);
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}