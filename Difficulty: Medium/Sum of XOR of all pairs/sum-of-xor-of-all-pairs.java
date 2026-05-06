class Solution {
    public long sumXOR(int[] arr) {
        int n = arr.length;
        if (n < 2) return 0;
        
        long total = 0;
        
        for (int k = 0; k < 32; k++) {
            long cnt1 = 0; 
            long mask = (1L << k);
            for (int num : arr) {
                if ((num & mask) != 0) {
                    cnt1++;
                }
            }
            
            long cnt0 = n - cnt1;
            long pairs = cnt0 * cnt1;
            total += pairs * (1L << k);
        }
        
        return total;
        
    }
}