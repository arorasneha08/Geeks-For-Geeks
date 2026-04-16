class Solution {
    public int myAtoi(String s) {
        s = s.trim(); 
        int n = s.length();
        if(n == 0) return 0;

        int sign = 1;
        int i = 0;

        if(s.charAt(i) == '+') {
            i++;
        } else if(s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        long res = 0;

        while(i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if(res > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + digit;
            i++;
        }

        return (int)(res * sign);
    }
}