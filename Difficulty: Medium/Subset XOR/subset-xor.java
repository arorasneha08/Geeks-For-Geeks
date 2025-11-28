class Solution {
    public static ArrayList<Integer> subsetXOR(int n) {
        ArrayList<Integer> res = new ArrayList<>(); 
        int xor = 0 ; 
        for(int i = 1 ; i <= n ; i++){
            xor ^= i ; 
        }
        if(xor == n){
            for(int i = 1 ; i <= n ; i++){
                res.add(i); 
            }
            return res; 
        }
        int remove = xor ^ n ; 
        for(int i = 1 ; i<= n ; i++){
            if(i != remove){
                res.add(i); 
            }
        }
        return res;
    }
}
