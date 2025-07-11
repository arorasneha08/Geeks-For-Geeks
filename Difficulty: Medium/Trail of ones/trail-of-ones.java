class Solution {
    int count = 0 ; 
    private void func(int idx , int n , boolean prev){
        if(idx == n) return ; 
        func(idx + 1, n , false);
        if(prev){
            count ++; 
        }
        func(idx + 1 , n , true); 
    }
    public int countConsec(int n) {
        if (n == 0) return 1; 
        long total = 1L << n; 
        long prevPrev = 1;
        long prev = 2;  
        
        for (int i = 2; i <= n; i++) {
            long current = prev + prevPrev;
            prevPrev = prev;
            prev = current;
        }
        
        return (int) (total - prev);
    }
}
