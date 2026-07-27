class Solution {
    public int maxWater(int arr[]) {
        int n = arr.length ; 
        // int prefMax[] = new int[n];
        // int suffMax[] = new int[n]; 
        
        // prefMax[0] = arr[0]; 
        // for(int i = 1 ; i < n ; i++){
        //     prefMax[i] = Math.max(prefMax[i-1] , arr[i]); 
        // }
        // suffMax[n-1] = arr[n-1]; 
        // for(int i = n-2 ; i >= 0 ; i--){
        //     suffMax[i] = Math.max(suffMax[i + 1] , arr[i]); 
        // }
        // int res = 0 ; 
        // for(int i = 0 ; i < n ; i++){
        //     res += Math.min(prefMax[i] , suffMax[i]) - arr[i]; 
        // }
        // return res; 
        
        int leftMax = 0 ; 
        int rightMax = 0  ;
        int left = 0 , right = n - 1 ; 
        int res = 0 ; 
        
        while(left < right){
            if(arr[left] > leftMax){
                leftMax = Math.max(leftMax , arr[left]); 
            }
            if(arr[right] > rightMax){
                rightMax = Math.max(rightMax , arr[right]); 
            }
            
            if(leftMax < rightMax){
                res += leftMax - arr[left]; 
                left ++; 
            }
            else {
                res += rightMax - arr[right]; 
                right -- ; 
            }
        }
        return res; 
    }
}
