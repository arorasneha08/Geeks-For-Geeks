class Solution {
    public static String caseSort(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();

        List<Character> upper = new ArrayList<>();
        List<Character> lower = new ArrayList<>();

        for (char c : ch) {
            if (Character.isUpperCase(c)) {
                upper.add(c);
            } else {
                lower.add(c);
            }
        }

        Collections.sort(upper);
        Collections.sort(lower);

        int upperIndex = 0, lowerIndex = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(ch[i])) {
                ch[i] = upper.get(upperIndex++);
            } else {
                ch[i] = lower.get(lowerIndex++);
            }
        }

        return new String(ch);
    }
}
