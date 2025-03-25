//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Solution obj = new Solution();
            System.out.println(obj.countWays(s));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int func(int i , int j ,boolean isTrue , String str, int dp[][][]){
        if (i > j) return 0;
        
        if (i == j) {
            if (isTrue) {
                return str.charAt(i) == 'T' ? 1 : 0;
            } else {
                return str.charAt(i) == 'F' ? 1 : 0;
            }
        }

        if (dp[i][j][isTrue ? 1 : 0] != -1) return dp[i][j][isTrue ? 1 : 0];

        int ways = 0;
        for (int index = i + 1; index < j; index += 2) {
            int leftTrue = func(i, index - 1, true, str, dp);
            int leftFalse = func(i, index - 1, false, str, dp);
            int rightTrue = func(index + 1, j, true, str, dp);
            int rightFalse = func(index + 1, j, false, str, dp);

            if (str.charAt(index) == '&') {
                if (isTrue) ways += leftTrue * rightTrue;
                else ways += (leftTrue * rightFalse) + (rightTrue * leftFalse) + (rightFalse * leftFalse);
            } else if (str.charAt(index) == '|') {
                if (isTrue) ways += (leftTrue * rightTrue) + (leftTrue * rightFalse) + (rightTrue * leftFalse);
                else ways += (rightFalse * leftFalse);
            } else { // XOR (^)
                if (isTrue) ways += (leftFalse * rightTrue) + (rightFalse * leftTrue);
                else ways += (leftFalse * rightFalse) + (leftTrue * rightTrue);
            }
        }

        return dp[i][j][isTrue ? 1 : 0] = ways;
    }
    static int countWays(String s) {
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }
        return func(0, n - 1, true, s, dp);
    }
}