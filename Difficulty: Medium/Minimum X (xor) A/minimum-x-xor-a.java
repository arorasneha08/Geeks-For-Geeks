class Solution {
    public static int countSetBit(int n){
        int count = 0;
        while(n > 0){
            count += (n & 1); 
            n >>= 1 ; 
        }
        return count;
    }
    public static int minVal(int a, int b) {
        int b_bit_count = countSetBit(b);
        int val = 0;
        for(int i=0;i<=a;i++){
            val = a ^ i;
            if(countSetBit(val) == b_bit_count){
                return val;
            }
        }
        return val;
    }
}