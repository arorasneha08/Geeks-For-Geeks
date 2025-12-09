class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>(); 
        int n = arr.length ; 
        HashMap<Integer , Integer> mpp = new HashMap<>(); 
        for(int num : arr){
            mpp.put(num , mpp.getOrDefault(num , 0) + 1); 
        }
        for(int num : mpp.keySet()){
            if(mpp.get(num) == 2){
                res.add(num); 
            }
        }
        return res;
    }
}