class Solution {
    int maxOnes(int[] arr) {
        // code here
        int maxi = 0;
        for(int a: arr) if(a == 1) maxi++;
        
        int mini = maxi;
        int cur = mini;
        for(int a: arr) {
            if(cur <= mini && a == 1) cur = mini;
            else if(a == 1) cur--;
            else cur++;
            maxi = Math.max(maxi, cur);
        }
        return maxi;
    }
};