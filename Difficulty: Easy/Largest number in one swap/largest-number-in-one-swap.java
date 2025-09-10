class Solution {
    public String largestSwap(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;

        // last[d] = last index where digit d appears
        int[] last = new int[10];
        for (int d = 0; d < 10; d++) last[d] = -1;
        for (int i = 0; i < n; i++) last[ch[i] - '0'] = i;

        // For each digit from left to right, try to swap with the largest possible digit (9..cur+1)
        for (int i = 0; i < n; i++) {
            int cur = ch[i] - '0';
            for (int d = 9; d > cur; d--) {
                if (last[d] > i) { // found a larger digit that occurs later
                    char tmp = ch[i];
                    ch[i] = ch[last[d]];
                    ch[last[d]] = tmp;
                    return new String(ch);
                }
            }
        }
        return new String(ch);
    }
}
