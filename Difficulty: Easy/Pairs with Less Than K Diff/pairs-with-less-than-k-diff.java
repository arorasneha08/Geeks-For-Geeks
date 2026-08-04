class Solution {
    public static int countPairs(int arr[], int k) {
        int n = arr.length ; 
        Arrays.sort(arr); 
        int i = 0 ;
        int count = 0; 
        for(int j = 0 ; j < n ; j++){
            while(arr[j] - arr[i] >= k){
                i++; 
            }
            count += (j - i); 
        }
        return count ; 
    }
}
