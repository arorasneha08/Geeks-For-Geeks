class Solution {
    public int maxWater(int arr[]) {
        int n = arr.length ; 
        int left = 0 , right = n-1 ; 
        int leftMax = 0 , rightMax = 0 ; 
        int ans = 0 ; 
        while(left < right){
            if(arr[left] > leftMax){
                leftMax = Math.max(leftMax, arr[left]);
            }
            if(arr[right] > rightMax){
                rightMax = Math.max(rightMax, arr[right]); 
            }
            if(leftMax < rightMax){
                ans += (leftMax - arr[left]); 
                left ++ ; 
            }
            else {
                ans += (rightMax - arr[right]);
                right -- ; 
            }
        }
        return ans ; 
    }
}
