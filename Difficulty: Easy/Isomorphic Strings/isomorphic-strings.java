class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        int n = s1.length();
        int m = s2.length(); 
        HashMap<Character , Character> mpp = new HashMap<>(); 
        if(n != m) return false; 
        
        for(int i = 0 ;  i < n ; i ++){
            char ch1 = s1.charAt(i); 
            char ch2 = s2.charAt(i); 
            if(mpp.containsKey(ch1)){
                if(mpp.get(ch1) == ch2) continue; 
                else return false; 
            }
            else if(mpp.containsValue(ch2)){
                return false;
            }
            else{
                mpp.put(ch1 , ch2); 
            }
        }
        return true; 
    }
}