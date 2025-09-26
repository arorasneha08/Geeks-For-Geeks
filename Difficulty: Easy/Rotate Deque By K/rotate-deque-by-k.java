class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        if(type == 1){
            while(!dq.isEmpty() && k > 0){
                int val = dq.pollLast(); 
                dq.offerFirst(val); 
                k--; 
            }
        }
        if(type == 2){
            while(!dq.isEmpty() && k > 0){
                int val = dq.pollFirst(); 
                dq.offerLast(val);
                k--; 
            }
        }
        
    }
}