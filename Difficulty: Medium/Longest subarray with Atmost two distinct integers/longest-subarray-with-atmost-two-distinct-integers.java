class Solution {
    public int totalElements(int[] arr) {
        int n = arr.length ; 
        int maxLen = 0 ; 
        int left = 0 ; 
        HashMap<Integer , Integer> mpp = new HashMap<>(); 
        for(int i = 0 ; i < n; i ++){
            mpp.put(arr[i] , mpp.getOrDefault(arr[i] , 0) + 1); 
            while(mpp.size() > 2){
                mpp.put(arr[left] , mpp.get(arr[left])-1); 
                if(mpp.get(arr[left]) == 0){
                    mpp.remove(arr[left]); 
                }
                left ++ ; 
            }
            maxLen = Math.max(maxLen , i - left + 1); 
        }
        return maxLen ; 
    }
}