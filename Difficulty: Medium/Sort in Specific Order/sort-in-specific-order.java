class Solution {
    private void reverse(int arr[] , int i , int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp; 
            i++; 
            j--; 
        }
    }
    public void sortIt(int[] arr) {
        int n = arr.length ;
        int i = 0 ;
        int j = n -1 ;
        int count = 0 ;
        
        while(i <= j){
            while(i < n  && arr[i] % 2 != 0){
                i++;
                count ++; 
            }
            while(j >= 0 && arr[j] % 2 == 0){
                j--; 
            }
            
            if(i < j){
                count ++; 
                int temp = arr[i];
                arr[i] = arr[j] ;
                arr[j] = temp; 
            }
            i++; 
            j-- ; 
        }
        Arrays.sort(arr, 0 , count); 
        Arrays.sort(arr , count , n); 
        
        reverse(arr, 0 , count - 1); 
    }
}
