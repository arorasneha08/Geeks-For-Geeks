class Solution {
    public int minOperations(int[] arr) {
        int n = arr.length ; 
        PriorityQueue<Double> pq = new PriorityQueue<>((a , b) -> Double.compare(b , a)); 
        int op = 0 ; 
        double total = 0 ; 
        for(int i = 0 ; i < n ; i++){
            total += arr[i]; 
        }
        double target = total / 2.0 ; 
        for(int num : arr){
            pq.offer((double) num); 
        }
        while(total - target > 1e-9){
            double val = pq.poll(); 
            double half = val / 2.0 ;  
            total -= (val - half) ; 
            pq.offer(half) ; 
            op ++ ;
        }
        return op ; 
    }
}