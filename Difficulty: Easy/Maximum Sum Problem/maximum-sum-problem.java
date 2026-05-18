class Solution {
    public int maxSum(int n) {
        // code here.
        if(n <=1)return n;
        return Math.max(n , maxSum(n/2) + maxSum(n/3) + maxSum(n/4));
    }
}
