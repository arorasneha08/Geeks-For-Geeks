class Solution {
    public class Pair implements Comparable<Pair>{
        char ch ; 
        int freq ; 
        Pair(char ch , int freq){
            this.ch = ch ; 
            this.freq = freq; 
        }
        public int compareTo(Pair other){
            if(this.freq == other.freq){
                return this.ch - other.ch ; 
            }
            return this.freq - other.freq; 
        }
    }
    public String frequencySort(String s) {
        int n = s.length(); 
        HashMap<Character , Integer> mpp = new HashMap<>(); 
        for(char ch : s.toCharArray()){
            mpp.put(ch , mpp.getOrDefault(ch , 0) + 1); 
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        for(Map.Entry<Character , Integer> entry : mpp.entrySet()){
            char key = entry.getKey(); 
            int val = entry.getValue(); 
            pq.offer(new Pair(key , val)); 
        }
        StringBuilder str = new StringBuilder(); 
        while(!pq.isEmpty()){
            Pair curr = pq.poll(); 
            char ch = curr.ch ; 
            int freq = curr.freq; 
            for(int i = 0 ; i < freq ; i++){
                str.append(ch); 
            }
        }
        return str.toString();
    }
};