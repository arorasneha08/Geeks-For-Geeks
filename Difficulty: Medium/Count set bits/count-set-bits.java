class Solution {
    public static int countSetBits(int n) {
        if (n == 0) return 0;

        int x = largestPowerOf2(n);
        int bitsUpTo2x = x * (1 << (x - 1));
        int msbBits = n - (1 << x) + 1;
        int remaining = n - (1 << x);

        return bitsUpTo2x + msbBits + countSetBits(remaining);
    }

    private static int largestPowerOf2(int n) {
        int x = 0;
        while ((1 << (x + 1)) <= n) {
            x++;
        }
        return x;
    }

    public static void main(String[] args) {
        int n = 17;
        System.out.println(countSetBits(n));
    }
}
