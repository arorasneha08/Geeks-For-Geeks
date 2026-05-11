class Solution {
    private boolean checkPalindrome(String str){
        int left = 0 ; 
        int right = str.length()-1 ;
        while(left <= right){
            if(str.charAt(left) != str.charAt(right)) return false ; 
            left ++; 
            right --; 
        }
        return true; 
    }
    public boolean palindromePair(String[] arr) {
        int n = arr.length ; 
        HashMap<String , Integer> mpp = new HashMap<>(); 
        for(int i = 0 ; i < n ; i++){
            mpp.put(arr[i] , i); 
        }
        for(int i = 0 ; i < n ; i++){
            String word = arr[i]; 
            int len = word.length(); 
            
            for(int j = 0 ; j <= len ; j++){
                String left = word.substring(0 , j); 
                String right = word.substring(j); 
                
                if(checkPalindrome(left)){
                    String rev = new StringBuilder(right).reverse().toString(); 
                    if(mpp.containsKey(rev) && mpp.get(rev) != i) {
                        return true; 
                    }
                }
                if(j != len && checkPalindrome(right)){
                    String rev = new StringBuilder(left).reverse().toString(); 
                    
                    if(mpp.containsKey(rev) && mpp.get(rev) != i){
                        return true; 
                    }
                }
            }
        }
        return false; 
    }
}