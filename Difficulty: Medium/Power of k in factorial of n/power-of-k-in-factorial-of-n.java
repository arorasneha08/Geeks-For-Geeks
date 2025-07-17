class Solution {
    private Map<Integer, Integer> primeFactors(int k) {
        Map<Integer, Integer> factors = new HashMap<>();
        for (int i = 2; i * i <= k; i++) {
            while (k % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }
        if (k > 1) {
            factors.put(k, factors.getOrDefault(k, 0) + 1);
        }
        return factors;
    }
    private int countPowerInFactorial(int n, int p) {
        int count = 0;
        long div = p;
        while (div <= n) {
            count += n / div;
            div *= p;
        }
        return count;
    }
    public int maxKPower(int n, int k) {
        Map<Integer, Integer> factors = primeFactors(k);
        int minPower = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : factors.entrySet()) {
            int prime = entry.getKey();
            int exponentInK = entry.getValue();

            int exponentInNFact = countPowerInFactorial(n, prime);
            minPower = Math.min(minPower, exponentInNFact / exponentInK);
        }

        return minPower;
    }
}