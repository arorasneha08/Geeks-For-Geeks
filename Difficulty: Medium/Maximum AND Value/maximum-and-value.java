class Solution {
    
    public int maxAND(List<Integer> arr) {
        int n = arr.size();
        int res = 0 ; 
        
        for(int bit = 31 ; bit >= 0 ; bit --){
            int temp = res | (1 << bit); 
            int count = 0 ; 
            
            for(int num : arr){
                if((num & temp) == temp){
                    count ++ ; 
                }
            }
            if(count >= 2){
                res = temp ;
            }
        }
        return res; 
    }
}
