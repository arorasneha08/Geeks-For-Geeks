class Solution {
    public int maxValue(int n) {
        int bitCount = 0;
        for (int i = 30; i >= 0; i--) {

            if ((n & (1 << i) )!= 0) {
                bitCount++;
            } else {
                bitCount = 0;
            }

            if (bitCount == 3) {
                n = (n & ~(1 << i)); 
                bitCount = 0;
            }
        }

        return n;
    }
}