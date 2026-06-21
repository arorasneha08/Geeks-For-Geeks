class Solution {
    public String chooseSwap(String s) {
         int n = s.length();

        int[] freq = new int[26];

        Arrays.fill(freq, -1);

        for (int i = 0; i < n; i++) {

            if (freq[s.charAt(i) - 'a'] == -1) {

                freq[s.charAt(i) - 'a'] = i;

            }

        }

        

        for (int i = 0; i < n; i++) {

            int cur = s.charAt(i) - 'a';

            for (int ch = 0; ch < cur; ch++) {

                if (freq[ch] > i) {

                    char c1 = s.charAt(i);

                    char c2 = (char) (ch + 'a');

                    char[] arr = s.toCharArray();

                    for (int j = 0; j < n; j++) {

                        if (arr[j] == c1) 

                            arr[j] = c2;

                         else if (arr[j] == c2) 

                            arr[j] = c1;

                        

                    }
                    return new String(arr);

                }

            }

        } 

        return s;
    }
}