class Solution {
    private static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }

    private static void backtrack(int start, String s, List<String> currentList, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (isPalindrome(prefix)) {
                currentList.add(prefix);
                backtrack(end, s, currentList, result);
                currentList.remove(currentList.size() - 1); 
            }
        }
    }

    public ArrayList<ArrayList<String>> palinParts(String s) {
        List<List<String>> tempResult = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), tempResult);

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (List<String> partition : tempResult) {
            result.add(new ArrayList<>(partition));
        }
        return result;
    }
}
