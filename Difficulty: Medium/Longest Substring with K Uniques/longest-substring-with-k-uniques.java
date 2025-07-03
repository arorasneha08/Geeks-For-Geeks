class Solution {
    public int longestKSubstr(String s, int k) {
        int n = s.length(); 
        int left = 0 ; 
        int len = -1 ; 
        HashMap<Character , Integer> mpp = new HashMap<>();
        for(int i = 0 ; i < n ; i ++){
            mpp.put(s.charAt(i) , mpp.getOrDefault(s.charAt(i) , 0) + 1); 
            while(mpp.size() > k){
                mpp.put(s.charAt(left) , mpp.get(s.charAt(left))-1); 
                if(mpp.get(s.charAt(left)) == 0){
                    mpp.remove(s.charAt(left)); 
                }
                left ++; 
            }
            if(mpp.size() == k){
                len = Math.max(len , i - left + 1);     
            }
        }
        return len ; 
    }
}