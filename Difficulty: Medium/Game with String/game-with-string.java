class Solution {
    public int minValue(String s, int k) {
        int n = s.length(); 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Character , Integer> mpp = new HashMap<>();
        for(int i = 0 ; i < n ; i ++){
            mpp.put(s.charAt(i) , mpp.getOrDefault(s.charAt(i) ,0) + 1); 
        }
        for(int val : mpp.values()){
            pq.offer(val); 
        }
        while(!pq.isEmpty() && k > 0){
            int val = pq.poll(); 
            k-- ; 
            val--;
            if(val > 0){
                pq.offer(val);
            }
        }
        int res = 0 ; 
        while(!pq.isEmpty()){
            int val = pq.poll();
            res += val * val ; 
        }
        return res; 
    }
}