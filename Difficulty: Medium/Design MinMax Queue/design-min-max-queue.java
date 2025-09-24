class SpecialQueue {
    Deque<Integer> dq ; 
    Deque<Integer> min ; 
    Deque<Integer> max ; 
    
    public SpecialQueue() {
        dq = new ArrayDeque<>(); 
        min = new ArrayDeque<>();
        max = new ArrayDeque<>(); 
    }

    public void enqueue(int x) {
        dq.offerLast(x); 
        while(!min.isEmpty() && min.peekLast() > x){
            min.pollLast(); 
        }
        min.offerLast(x); 
        while(!max.isEmpty() && max.peekLast() < x){
            max.pollLast(); 
        }
        max.offerLast(x); 
    }

    public void dequeue() {
        if (dq.isEmpty()) return;
        int val = dq.pollFirst(); 
        if(!min.isEmpty() && min.peekFirst() == val){
            min.pollFirst(); 
        }
        if(!max.isEmpty() && max.peekFirst() == val){
            max.pollFirst() ;
        }
    }

    public int getFront() {
        if(dq.isEmpty()) return -1; 
        return dq.peekFirst(); 
    }

    public int getMin() {
        if(min.isEmpty()) return -1; 
        return min.peekFirst(); 
    }

    public int getMax() {
        if(max.isEmpty()) return -1; 
        return max.peekFirst() ;
    }
}