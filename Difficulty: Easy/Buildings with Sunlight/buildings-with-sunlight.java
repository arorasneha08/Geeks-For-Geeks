class Solution {
    public int visibleBuildings(int arr[]) {
        int n = arr.length ; 
        int max = 0 ;
        int count = 1 ;
        for(int i = 1 ; i < n; i++){
            if(arr[i] >= arr[max]){
                count ++; 
                max = i ; 
            }
        }
        return count ;
    }
}