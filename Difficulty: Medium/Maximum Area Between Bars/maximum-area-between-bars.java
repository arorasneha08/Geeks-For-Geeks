class Solution {
    public int maxArea(List<Integer> height) {
        if (height.size() <= 1) {
            return 0;
        }
        
        int maxi = 0;
        int i = 0;
        int j = height.size() - 1;
        
        while (i < j) {
            int val = Math.min(height.get(i), height.get(j)) * (j - i - 1);
            maxi = Math.max(maxi, val);
            
            if (height.get(i) <= height.get(j)) {
                i++;
            } else {
                j--;
            }
        }
        
        return maxi;
    }
}