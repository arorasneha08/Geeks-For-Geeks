class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int n = arr.length ; 
        int max = Integer.MIN_VALUE ;
        int sec = Integer.MIN_VALUE ;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] > max){
                sec = max; 
                max = arr[i]; 
            }
            else if(arr[i] < max && arr[i] > sec){
                sec = arr[i]; 
            }
        }
        if(sec == Integer.MIN_VALUE) return -1; 
        return sec ;
    }
}