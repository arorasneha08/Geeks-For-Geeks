class Solution {
    public boolean checkWithinK(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> mpp = new HashMap<>(); 
        
        for(int i = 0 ; i < n ; i++){
            if(mpp.containsKey(arr[i])){
                if(i - mpp.get(arr[i]) <= k){
                    return true; 
                }
            }
            mpp.put(arr[i] , i); 
        }
        return false;
    }
}