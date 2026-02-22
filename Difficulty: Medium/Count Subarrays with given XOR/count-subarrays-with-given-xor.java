class Solution {
    public long subarrayXor(int arr[], int k) {
        int n = arr.length ; 
        int currxor = 0 ;
        int count = 0 ;
        int xor = 0 ;
        HashMap<Integer , Integer> mpp = new HashMap<>() ;
        mpp.put(0,1); 
        for(int i = 0 ; i<n ; i++){
            currxor = arr[i] ^ currxor ;  
            xor = currxor ^ k ;
            if(mpp.containsKey(xor)){
                count += mpp.get(xor); 
            }
            mpp.put(currxor , mpp.getOrDefault(currxor , 0) + 1); 
        }
        return count ; 
    }
}