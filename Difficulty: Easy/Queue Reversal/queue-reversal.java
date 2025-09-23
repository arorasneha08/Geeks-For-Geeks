class Solution {
    public void reverseQueue(Queue<Integer> q) {
        int n = q.size(); 
        if(q.isEmpty()) return ; 
        int top = q.poll(); 
        reverseQueue(q) ;
        q.offer(top); 
    }
}