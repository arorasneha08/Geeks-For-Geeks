class Solution {
    public String largestSwap(String s) {
        int n = s.length(); 
        int idx1 = -1;
        int idx2 = -1; 
        int i = n - 1;

        for(int j = n - 1; j >= 0; j--){
            char ch1 = s.charAt(j); 
            char ch2 = s.charAt(i); 

            if(ch1 == ch2) continue; 

            if(ch1 > ch2){
                i = j;
            }
            else{
                idx1 = i; 
                idx2 = j; 
            }
        }

        if(idx1 == -1){
            return s;
        }

        char[] chs = s.toCharArray();

        char temp = chs[idx1];
        chs[idx1] = chs[idx2];
        chs[idx2] = temp;

        return new String(chs);
    }
}