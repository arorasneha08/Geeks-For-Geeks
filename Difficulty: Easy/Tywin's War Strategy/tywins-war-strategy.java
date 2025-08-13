class Solution {
    public int minSoldiers(int[] arr, int k) {
        int n = arr.length ; 
        int luckyTroops = (n+1)/2 ; 
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        int count = 0 ; 
        for(int i = 0 ; i < n ; i++){
            int r = arr[i] % k ; 
            if(r == 0){
                count ++; 
            }
            else{
                pq.offer(k - r ); 
            }
        }
        int res = 0 ; 
        while(!pq.isEmpty() && count < luckyTroops){
            res += pq.poll(); 
            count ++; 
        }
        return res; 
    }
}