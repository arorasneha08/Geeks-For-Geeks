class Solution {
    public int catchThieves(char[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 'T'){
                pq.offer(i);
            }
        }
        
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(pq.size() <= 0) break;
            
            if(arr[i] == 'P'){
                int idx = pq.peek();
                if(idx > i+k) continue;
            
                while(idx <= i+k){
                    idx = pq.poll();
                    if(Math.abs(i - idx) <= k){
                        cnt++;
                        break;
                    }
                }
                 
            }
        }
        
        return cnt;
        
        
    }
}