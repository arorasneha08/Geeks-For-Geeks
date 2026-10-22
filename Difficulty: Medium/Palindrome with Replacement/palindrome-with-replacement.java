class Solution {
    public int minimumSum(String s) {
        int n = s.length(); 
        
        for(int i = 0 ; i < n / 2 ; i++){
            char left = s.charAt(i); 
            char right = s.charAt(n-i-1); 
            if(left != '?' && right != '?' && left != right){
                return -1; 
            }
        }
        int sum = 0 ; 
        char prev = '?'; 
        
        for(int i = 0 ; i <= (n-1)/2 ; i++){
            char left = s.charAt(i); 
            char right = s.charAt(n-i-1); 
            char curr ; 
            
            if(left != '?'){
                curr = left; 
            }
            else{
                curr = right; 
            }
            
            if(curr == '?'){
                continue; 
            }
            
            if(prev != '?'){
                sum += Math.abs(curr - prev); 
            }
            prev = curr; 
        }
        return 2 * sum ; 
    }
}
