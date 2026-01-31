class kQueues {
    HashMap<Integer , Queue<Integer>> mpp = new HashMap<>(); 
    int size ; 
    int n ; 
    int k ; 
    
    kQueues(int n, int k) {
        this.size = 0 ; 
        this.n = n ; 
        this.k = k ; 
    }

    void enqueue(int x, int i) {
        if(isFull()) return ; 
        if(!mpp.containsKey(i)){
            mpp.put(i , new LinkedList<>());
        }
        mpp.get(i).add(x); 
        size ++; 
    }

    int dequeue(int i) {
        Queue<Integer> q = mpp.get(i); 
        if(q == null || q.isEmpty()) return -1;
        size -- ; 
        return q.poll(); 
    }

    boolean isEmpty(int i) {
        Queue<Integer> q = mpp.get(i); 
        return q == null || q.size() == 0 ; 
    }

    boolean isFull() {
        if(size == n) return true; 
        return false;
    }
}
