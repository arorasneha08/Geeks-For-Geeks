class Solution {
    public boolean canServe(int[] arr) {
        int n = arr.length; 
        int fives = 0 ;
        int tens = 0 ; 
        
        for(int i = 0 ; i < n ; i ++){
            if(arr[i] == 5) fives ++;
            else if(arr[i] == 10){
                if(fives > 0){
                    fives -- ; 
                    tens ++; 
                }
                else{
                    return false ;
                }
            }
            else if(arr[i] == 20){
                if(tens > 0 && fives > 0){
                    tens --; 
                    fives -- ;
                }
                else if(fives > 2){
                    fives -= 3 ; 
                }
                else{
                    return false; 
                }
            }
        }
        return true; 
    }
}