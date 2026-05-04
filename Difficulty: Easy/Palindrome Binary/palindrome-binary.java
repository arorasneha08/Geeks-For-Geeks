class Solution {
    
    public static boolean checkPallindrome(String binary)
    {
        int n = binary.length();
        
        int start = 0;
        int end = n-1;
        
        while(start <= end)
        {
            char chs = binary.charAt(start);
            char che = binary.charAt(end);
            
            if(che != chs) return false;
            else{
                start++;
                end--;
            }
        }
        return true;
    }
    static boolean isBinaryPalindrome(long N) {
        // code here
        String binary = Long.toBinaryString(N);
        
        boolean check = checkPallindrome(binary);
        
        if(check) return true ; 
        else return false ; 
    }
}