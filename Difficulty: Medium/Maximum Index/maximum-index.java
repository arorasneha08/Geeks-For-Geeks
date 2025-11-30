class Solution {

    int maxIndexDiff(int arr[]) {
        int n = arr.length ; 
        int leftMin[] = new int[n] ;
        int rightMax[] = new int[n]; 
        leftMin[0] = arr[0] ; 
        rightMax[n-1] = arr[n-1];
        
        for(int i = 1 ; i < n ; i++){
            leftMin[i] = Math.min(leftMin[i-1] , arr[i]) ; 
        }
        for(int i = n-2 ; i>= 0 ; i--){
            rightMax[i] = Math.max(rightMax[i + 1] , arr[i]); 
        }
        int i = 0 ; 
        int j = 0 ; 
        int res = 0 ;
        while(i < n && j < n){
            if(leftMin[i] <= rightMax[j]){
                res = Math.max(res , j - i); 
                j++; 
            }
            else{
                i++ ; 
            }
        }
        return res; 
    }
}