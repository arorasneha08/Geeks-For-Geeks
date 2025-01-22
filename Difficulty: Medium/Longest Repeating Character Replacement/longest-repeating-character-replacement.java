//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            s = s.toUpperCase();
            int ans = obj.characterReplacement(s, k);
            System.out.println(ans);

            System.out.println("~");
        }
    }

    static class FastReader {

        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;

        FastReader(InputStream is) { in = is; }

        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }

        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan())
                ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char)c);
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }

        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int characterReplacement(String s, int k) {
        int n = s.length();
    HashMap<Character, Integer> mpp = new HashMap<>();
    int maxLen = 0;
    int left = 0;
    int maxFreq = 0;

    for (int right = 0; right < n; right++) {
        char rightChar = s.charAt(right);
        mpp.put(rightChar, mpp.getOrDefault(rightChar, 0) + 1);
        maxFreq = Math.max(maxFreq, mpp.get(rightChar)); // Update maxFreq based on the current character count

        while ((right - left + 1) - maxFreq > k) {
            char leftChar = s.charAt(left);
            mpp.put(leftChar, mpp.get(leftChar) - 1);
            if (mpp.get(leftChar) == 0) {
                mpp.remove(leftChar); // Correct key for removal
            }
            left++;
        }

        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
    }
}
