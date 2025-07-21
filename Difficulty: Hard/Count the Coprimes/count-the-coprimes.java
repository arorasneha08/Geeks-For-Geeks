import java.util.*;

class Solution {
    int[] mobius;
    int maxVal;

    public int cntCoprime(int[] arr) {
        maxVal = 0;
        for (int num : arr) maxVal = Math.max(maxVal, num);

        // Precompute Mobius function up to max element
        mobius = getMobius(maxVal);

        int[] freq = new int[maxVal + 1];
        for (int num : arr) freq[num]++;

        int[] divCount = new int[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            for (int j = i; j <= maxVal; j += i) {
                if (freq[j] > 0) {
                    divCount[i] += freq[j];
                }
            }
        }

        long coprimePairs = 0;
        for (int i = 1; i <= maxVal; i++) {
            if (mobius[i] != 0 && divCount[i] >= 2) {
                long c = divCount[i];
                coprimePairs += (long) mobius[i] * c * (c - 1) / 2;
            }
        }

        return (int) coprimePairs;
    }

    private int[] getMobius(int n) {
        int[] mobius = new int[n + 1];
        Arrays.fill(mobius, 1);
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i; j <= n; j += i) {
                mobius[j] *= -1;
                isPrime[j] = false;
            }
            long sq = 1L * i * i;
            if (sq <= n) {
                for (int j = (int) sq; j <= n; j += sq) {
                    mobius[j] = 0;
                }
            }
        }

        return mobius;
    }
}
