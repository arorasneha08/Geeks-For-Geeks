class Solution {
    public boolean subArrayExists(int arr[]) {
        int n = arr.length ; 
        HashMap<Integer , Integer> mpp = new HashMap<>(); 
        int sum = 0 ; 
        int max = 0 ; 
        for(int i = 0 ; i < n ; i++){
            sum += arr[i]; 
            if(mpp.containsKey(sum)){
                return true; 
            }
            if(sum == 0) return true; 
        
            mpp.put(sum , i); 
        }
        return false; 
    }
}