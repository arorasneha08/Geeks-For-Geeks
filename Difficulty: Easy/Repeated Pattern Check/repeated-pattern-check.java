class Solution {
    public boolean findPattern(String s) {
        int count = 0  ;

        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i); 
            if(ch == 'x') count ++; 
            else if(ch == 'y'){
                if(count == 0) return false; 
                
                count --; 
            }
        }    
        if(count == 0) return true;
        return false;
    }
}
