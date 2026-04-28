class Solution {
    public int longestSubstr(String s, int k) {
        int n = s.length(); 
        int left = 0 ; 
        HashMap<Character , Integer> mpp = new HashMap<>();
        int max = 0 ; 
        int maxFreq = 0 ; 
        
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i) ;
            mpp.put(ch, mpp.getOrDefault(ch , 0) + 1); 
            maxFreq = Math.max(maxFreq, mpp.get(ch)); 
            
            while((i - left + 1) - maxFreq > k){
                mpp.put(s.charAt(left) , mpp.get(s.charAt(left))-1);
                if(mpp.get(s.charAt(left)) == 0){
                    mpp.remove(s.charAt(left)); 
                }
                left ++;
            }
            max = Math.max(max , i -left + 1); 
        }
        return max; 
    }
}
