class Solution {

    public int subsequenceSum(String s) {

        int n = s.length();

        if (n == 0) return 0; 

        int mod = 1_000_000_007;

        long sum = 0;
        for (char c : s.toCharArray()) {

            sum += c - '0';

        }

        sum %= mod;

        long pow = power(2, n - 1, mod);



        return (int) ((sum * pow) % mod);

    }
    private long power(long base, long exp, int mod) {

        long res = 1;

        base %= mod;

        while (exp > 0) {

            if ((exp & 1) == 1) { 

                res = (res * base) % mod;

            }

            base = (base * base) % mod;

            exp >>= 1; 
        }

        return res;

    }

}

