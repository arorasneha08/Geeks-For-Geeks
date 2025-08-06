class Solution {
    public int romanToDecimal(String s) {
        int n = s.length();
        HashMap<Character , Integer> mpp = new HashMap<>(); 
        mpp.put('I' , 1); 
        mpp.put('V' , 5); 
        mpp.put('X' , 10); 
        mpp.put('L' , 50); 
        mpp.put('D' , 500); 
        mpp.put('M' , 1000); 
        mpp.put('C' , 100); 
        int res = 0 ; 
        if(n == 1){
            return mpp.get(s.charAt(0)); 
        }
        for(int i = 0 ; i < n-1; i++){
            if(mpp.get(s.charAt(i)) < mpp.get(s.charAt(i+1))){
                res -= mpp.get(s.charAt(i)); 
            }
            else {
                res += mpp.get(s.charAt(i)); 
            }
        }
        res += mpp.get(s.charAt(n-1)); 
        return res; 
    }
}