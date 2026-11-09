class Solution {
    int getCount(String s, int k) {
        
        int n = s.length() ;
        int i = 0 ; 
        HashMap<Character, Integer> mpp = new HashMap<>(); 
        
        while(i < n){
            char ch = s.charAt(i); 
            mpp.put(ch , mpp.getOrDefault(ch , 0) + 1); 
            
            int j = i + 1; 
            while(j < n && s.charAt(j) == ch){
                j++; 
            }
            i = j ; 
        }
        int count = 0 ; 
        
        for(int freq : mpp.values()){
            if(freq == k) count ++; 
        }
        return count; 
    }
}