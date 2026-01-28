class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        int n = arr.length; 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b , a)); 
        for(int num : arr){
            pq.offer(num); 
        }
        ArrayList<Integer> res = new ArrayList<>(); 
        while(!pq.isEmpty() && k > 0){
            res.add(pq.poll()); 
            k-- ;
        }
        return res;
    }
}
