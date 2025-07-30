

// User function Template for Java
class Solution {
    public int cntSubarrays(int arr[], int k) {
        int n = arr.length ; 
        int sum = 0 ; 
        int count = 0 ;
        HashMap<Integer, Integer> mpp = new HashMap<>(); 
        mpp.put(0,1);
        for(int i = 0; i< n ; i++){
            sum += arr[i] ; 
            int rem = sum - k ; 
            if(mpp.containsKey(rem)){
                count += mpp.get(rem);
            }
            mpp.put(sum, mpp.getOrDefault(sum , 0) + 1); 
        }
        return count ; 
    }
}