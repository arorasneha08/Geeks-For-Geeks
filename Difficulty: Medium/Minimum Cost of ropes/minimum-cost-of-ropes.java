class Solution {
    public static int minCost(int[] arr) {
        int n = arr.length ;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        for(int i = 0 ; i < n ; i ++){
            pq.offer(arr[i]); 
        }
        int total = 0 ; 
        while(pq.size() > 1){
            int val1 = pq.poll(); 
            int val2 = pq.poll(); 
            int sum = val1 + val2 ; 
            total += sum ; 
            pq.offer(sum); 
        }
        return total; 
    }
}