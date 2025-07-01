class Solution {
    public int substrCount(String s, int k) {
        if (s.length() < k) return 0;

        int count = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            if (i >= k) {
                char outChar = s.charAt(i - k);
                freqMap.put(outChar, freqMap.get(outChar) - 1);
                if (freqMap.get(outChar) == 0) {
                    freqMap.remove(outChar);
                }
            }
            if (i >= k - 1 && freqMap.size() == k - 1) {
                count++;
            }
        }

        return count;
    }
}
