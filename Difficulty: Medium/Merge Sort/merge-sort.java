

class Solution {
    void merge(int arr[] , int low ,int mid , int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int n = arr.length ; 
        int i = low ; 
        int j = mid + 1;
        while(i <= mid  && j <= high){
            if(arr[i] <= arr[j]){
                temp.add(arr[i]);
                i ++ ;
            }
            else {
                temp.add(arr[j]);
                j++; 
            }
        }
        while(i <= mid){
            temp.add(arr[i]); 
            i++ ;
        }
        while(j <= high){
            temp.add(arr[j]);
            j++;
        }
        for (int k = 0; k < temp.size(); k++) {
            arr[low + k] = temp.get(k);
        }
    }

    void mergeSort(int arr[], int l, int r) {
        if(l >= r) return ;
        int mid = l + (r - l) / 2;
        mergeSort(arr, l , mid );
        mergeSort(arr, mid + 1 , r);
        merge(arr , l , mid , r) ;
    }
}
