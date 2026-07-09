class Solution {
    public int countKdivPairs(int[] arr, int k) {
        int ans = 0;
        int[] rem = new int [k];
        
        for(int val: arr) {
            int r = val % k;
            int left = (k - r) % k;
            ans += rem[left];
            rem[r]++;
        }
        return ans;
    }
}