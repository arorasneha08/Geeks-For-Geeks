//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int r = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    static final int MOD = 1_000_000_007;

    public int nCr(int n, int r) {
        if (r > n) return 0;
        List<Integer> prev = new ArrayList<>();
        prev.add(1);

        for (int i = 1; i <= n; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1);

            for (int j = 1; j < i; j++) {
                int val = (int)(((long)prev.get(j - 1) + prev.get(j)) % MOD);
                curr.add(val);
            }

            curr.add(1); // nCn = 1
            prev = curr;
        }

        return prev.get(r);
    }
}
