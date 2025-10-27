class Solution {
    public class Pair implements Comparable<Pair>{
        int val1 ;
        int val2 ;
        int idx ; 
        
        Pair(int val1 , int val2 , int idx){
            this.val1 = val1 ; 
            this.val2 = val2 ;
            this.idx = idx; 
        }
        public int compareTo(Pair other){
            return Integer.compare(this.val1 + this.val2, other.val1 + other.val2);
        }
    }
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(); 
        int n = arr1.length ; 
        int m = arr2.length ; 
        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        for(int i = 0 ; i < Math.min(n, k) ; i ++){
            pq.offer(new Pair(arr1[i] , arr2[0] , 0)) ;
        }
        while(!pq.isEmpty() && k > 0){
            ArrayList<Integer> list = new ArrayList<>(); 
            Pair curr = pq.poll(); 
            list.add(curr.val1); 
            list.add(curr.val2);
            res.add(list); 
            
            if(curr.idx + 1 < m){
                pq.offer(new Pair(curr.val1 , arr2[curr.idx + 1], curr.idx + 1));
            }
            k-- ; 
        }
        return res; 
    }
}
