class Solution {
    public class Pair implements Comparable<Pair>{
        int node; 
        int freq ; 
        Pair(int node , int freq){
            this.node = node; 
            this.freq = freq;
        }
        public int compareTo(Pair other){
            if(this.freq == other.freq){
                return other.node - this.node; 
            }
            return other.freq - this.freq ;
        }
    }
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        int n = arr.length ;  
        ArrayList<Integer> res = new ArrayList<>(); 
        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        HashMap<Integer , Integer> mpp = new HashMap<>(); 
        
        for(int num : arr){
            mpp.put(num , mpp.getOrDefault(num , 0) + 1); 
        }
        for(Map.Entry<Integer , Integer> entry : mpp.entrySet()){
            int key = entry.getKey(); 
            int val = entry.getValue(); 
            pq.offer(new Pair(key , val)); 
        }
        while(!pq.isEmpty() && k > 0){
            res.add(pq.poll().node);
            k--;
        }
        return res; 
    }
}
