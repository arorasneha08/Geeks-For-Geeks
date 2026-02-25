class Solution {
    public int longestSubarray(int[] arr, int k) {
       int n = arr.length, count = 0, length = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < n; i++){
            if(arr[i] <= k) count--;
            else count++;
            
            if(count > 0) length = Math.max(length, i + 1);
            if(map.containsKey(count - 1)) length = Math.max(length, i - map.get(count - 1));
            
            if(!map.containsKey(count)) map.put(count, i);
        }
        return length;
    }
}