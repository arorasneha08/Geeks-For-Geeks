class Solution {
    private static int[] makelps(String pat , int lps[]){
        int m = pat.length();
        lps[0]  = 0 ; 
        int len  = 0 ;
        int i = 1  ;
        while(i < m){
            if(pat.charAt(i) == pat.charAt(len)){
                len ++ ;
                lps[i] = len ; 
                i++ ; 
            }
            else {
                if(len != 0){
                    len = lps[len-1]; 
                }
                else {
                    lps[i] = 0 ;
                    i++; 
                }
            }
        }
        return lps; 
    }
    public boolean areRotations(String txt, String pat) {
        int n = txt.length(); 
        int m = pat.length();
        int lps[] = new int[m]; 
        txt = txt + txt ; 
        lps = makelps(pat , lps); 
        
        int i = 0 ; 
        int j = 0 ; 
        while(i < txt.length()){
            if(txt.charAt(i) == pat.charAt(j)){
                i++; 
                j++ ;
                if(j == pat.length()) return true; 
            }
            
            else{
                if(j != 0){
                    j = lps[j-1]; 
                }
                else{
                    i++; 
                }
            }
        }
        return false ; 
    }
}