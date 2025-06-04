class Solution {
    int helper(String s1,String s2,String s3,int i,int j,int k,int[][][] memo) {
        if(i >= s1.length() || j >= s2.length() || k >= s3.length())
            return 0;
            
        if(memo[i][j][k] != -1) return memo[i][j][k];
        
        if(s1.charAt(i) == s2.charAt(j) && s1.charAt(i) == s3.charAt(k))
            return memo[i][j][k] = 1 + helper(s1,s2,s3,i + 1,j + 1,k + 1,memo);
        else {
            int op1 = helper(s1,s2,s3,i + 1,j,k,memo);
            int op2 = helper(s1,s2,s3,i,j + 1,k,memo);
            int op3 = helper(s1,s2,s3,i,j,k + 1,memo);
            
            return memo[i][j][k] = Math.max(op1,Math.max(op2,op3));
        }
    }
    int lcsOf3(String s1, String s2, String s3) {
        int[][][] memo = new int[s1.length()][s2.length()][s3.length()];
        for(int[][] mem : memo)
            for(int[] m : mem)
                Arrays.fill(m,-1);
                
        return helper(s1,s2,s3,0,0,0,memo);
    }
}