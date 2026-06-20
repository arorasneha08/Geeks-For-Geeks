class Solution {
    public int getLastDigit(String a, String b) {
        int lastD = a.charAt(a.length()-1) - '0';
        
        int[][] c = {
            {0},
            {1},
            {2,4,8,6},
            {3,9,7,1},
            {4,6},
            {5},
            {6},
            {7,9,3,1},
            {8,4,2,6},
            {9,1}
        };
        int[] cycle = c[lastD];
        int cLen = cycle.length;
        int mod = 0;
        
        for(int i=0; i<b.length(); i++){
            mod = (mod * 10 + (b.charAt(i) - '0')) % cLen;
        }
        if(mod == 0) mod = cLen;
        
        return cycle[mod -1];
    }
};