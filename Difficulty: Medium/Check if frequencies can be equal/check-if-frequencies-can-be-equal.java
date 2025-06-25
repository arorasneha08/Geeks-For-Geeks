class Solution {
    boolean sameFreq(String s) {
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        
        TreeMap<Integer,Integer> mpp = new TreeMap<>();

        for(int i = 0 ; i < 26 ; i++){
            int f = freq[i];
            if(f == 0) continue;
            if(mpp.containsKey(f)){
                mpp.put(f , mpp.get(f) + 1);
            }
            else {
                mpp.put(f,1);
            }
        }
        if(mpp.size() > 2) return false;       
        if(mpp.size() == 1) return true;       
        
        int fk = mpp.firstKey();
        int lk = mpp.lastKey();
        
        if(lk == fk + 1 && mpp.get(lk) == 1){     
            return true;
        }
        
        if(fk == 1 && mpp.get(fk) == 1){       
            return true;
        }
        return false;
    }
}