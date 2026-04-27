class Solution {
    public int smallestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int minLen = Integer.MAX_VALUE;

        HashMap<Character, Integer> mpp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);

            while (mpp.size() == 3) {
                minLen = Math.min(minLen, i - left + 1);

                char leftChar = s.charAt(left);
                mpp.put(leftChar, mpp.get(leftChar) - 1);

                if (mpp.get(leftChar) == 0) {
                    mpp.remove(leftChar);
                }

                left++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
    }
}