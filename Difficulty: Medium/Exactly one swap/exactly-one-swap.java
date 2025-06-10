class Solution {
    int countStrings(String s) {
        int n = s.length(); 
        long total = (long) n * (n-1)/2; 
        HashMap<Character , Integer> mpp = new HashMap<>(); 
        for(char ch : s.toCharArray()){
            mpp.put(ch , mpp.getOrDefault(ch , 0) + 1); 
        }
        long dupl = 0 ; 
        boolean isDup = false; 
        for(int val : mpp.values()){
            if(val > 1){
                isDup = true ; 
                dupl += (long) val * (val - 1)/2 ; 
            }
        }
        long diff = total - dupl ; 
        if(isDup){
            diff += 1; 
        }
        return (int) diff; 
    }
}