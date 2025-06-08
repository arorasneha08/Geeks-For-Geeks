import java.math.BigInteger;

class Solution {
    private boolean check(int i, int j, int k, String s) {
        if (k == s.length()) return true;
        if (k > s.length()) return false;

        String sa = s.substring(i, j);
        String sb = s.substring(j, k);

        if ((sa.length() > 1 && sa.charAt(0) == '0') || (sb.length() > 1 && sb.charAt(0) == '0')) {
            return false;
        }

        BigInteger a = new BigInteger(sa);
        BigInteger b = new BigInteger(sb);
        BigInteger sum = a.add(b);
        String sumStr = sum.toString();

        if (!s.startsWith(sumStr, k)) {
            return false;
        }

        return check(j, k, k + sumStr.length(), s);
    }

    public boolean isSumString(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(0, i, j, s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
