

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
       int n = arr.length ;
       
       ArrayList<Integer> result = new ArrayList<>();
       HashMap<Integer , Integer> mpp = new HashMap<>();
       
        for (int i = 0; i < k; i++) {
            mpp.put(arr[i], mpp.getOrDefault(arr[i], 0) + 1);
        }
        result.add(mpp.size());
        
        for (int i = k; i < n; i++) {
            int left = arr[i - k];
            mpp.put(left, mpp.get(left) - 1);
            if (mpp.get(left) == 0) {
                mpp.remove(left);
            }
            int right = arr[i];
            mpp.put(right, mpp.getOrDefault(right, 0) + 1);

            result.add(mpp.size());
        }
        return result ; 
    }
}
