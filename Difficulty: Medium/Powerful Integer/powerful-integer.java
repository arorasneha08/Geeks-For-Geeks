class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        TreeMap<Integer, Integer> events = new TreeMap<>();

        for (int[] interval : intervals) {
            events.put(interval[0], events.getOrDefault(interval[0], 0) + 1);
            events.put(interval[1] + 1, events.getOrDefault(interval[1] + 1, 0) - 1);
        }

        int count = 0;
        int result = -1;

        for (Map.Entry<Integer, Integer> entry : events.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue() ;
            
            if(val >= 0){
                count += val ;
                if(count >= k ){
                    result = key ; 
                }
            }
            else{
                if(count >= k){
                    result = key - 1; 
                }
                count += val ;
            }
        }
        return result ;
    }
}
