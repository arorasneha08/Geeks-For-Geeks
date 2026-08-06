class Solution {
    public int countMinOperations(int arr[]) {
        int n = arr.length ; 
        int dble = 0 ; 
        int add = 0 ; 
        for(int i = 0 ; i < n ; i++){
            int count = 0 ; 
            int val = arr[i]; 
            while(val != 0){
                if(val % 2 != 0){
                    add ++; 
                    val --; 
                }
                else{
                    count ++; 
                    val /= 2 ; 
                }
            }
            dble = Math.max(dble , count); 
        }
        return dble + add ; 
    }
}