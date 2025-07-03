class Solution {
    public int countAtMostK(int arr[], int k) {
        int count = 0 ; 
        int n = arr.length; 
        HashMap<Integer , Integer> mpp = new HashMap<>();
        int left = 0 ;
        for(int i = 0 ; i < n ; i ++){
            mpp.put(arr[i], mpp.getOrDefault(arr[i] , 0) + 1); 
            while(mpp.size() > k){
                mpp.put(arr[left] , mpp.get(arr[left])-1); 
                if(mpp.get(arr[left]) == 0){
                    mpp.remove(arr[left]); 
                }
                left ++; 
            }
            count += (i - left + 1); 
        }
        return count; 
    }
}
