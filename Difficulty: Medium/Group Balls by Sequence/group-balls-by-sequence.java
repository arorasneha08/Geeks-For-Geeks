class Solution {
    public boolean validgroup(int[] arr, int k) {
        int n = arr.length ; 
        if(n % k != 0) return false; 
        TreeMap<Integer , Integer> mpp =  new TreeMap<>(); 
        for(int i = 0 ;  i < n ; i++){
            mpp.put(arr[i] , mpp.getOrDefault(arr[i] , 0) + 1); 
        }
        while(!mpp.isEmpty()){
            int val = mpp.firstKey(); 
            for(int i = 0 ; i < k ; i++){
                int curr = val + i ;  
                if(!mpp.containsKey(curr)){
                    return false; 
                }
                mpp.put(curr , mpp.get(curr)- 1); 
                if(mpp.get(curr) == 0){
                    mpp.remove(curr); 
                }
            }
        }
        return true; 
    }
}