class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length ; 
        HashSet<Integer> set = new HashSet();
        for(int i = 0 ; i < n ; i++){
            set.add(arr[i] * arr[i]); 
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                int sum = arr[i]* arr[i]  + arr[j] * arr[j]; 
                if(set.contains(sum)){
                    return true ; 
                }
            }
        }
        return false; 
    }
}