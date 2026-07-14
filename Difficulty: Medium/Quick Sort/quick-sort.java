

class Solution {
    static void swap(int left , int right , int arr[]){
        int temp = arr[left];
        arr[left] = arr[right]; 
        arr[right] = temp ; 
    }

    static void quickSort(int arr[], int low, int high) {
        if(low >= high) return; 
        int pi = partition(arr , low , high);
        quickSort(arr, low , pi -1); 
        quickSort(arr, pi +1 , high);
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int count = 0 ;
        for(int i = low +1  ; i<= high ; i++){
            if(arr[i]<=pivot){
                count ++ ; 
            }
        }
        int pivot_index = low + count;
        swap(low, pivot_index, arr);
        int i = low , j = high ; 
        while (i<pivot_index && j>pivot_index) {
            while (arr[i]<=pivot) {
                i++ ; 
            }
            while (arr[j]>pivot) {
                j--;
            }
            if(i<pivot_index && j>pivot_index){
                swap(i, j , arr);
                i++ ;  
                j-- ; 
            }
        }
        return pivot_index;
    }
}
