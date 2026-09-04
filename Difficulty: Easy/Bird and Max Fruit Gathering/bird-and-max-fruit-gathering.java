class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size(); 
        if(n == 0 || m <= 0) return 0 ; 
        
        if(m >= n){
            int total = 0; 
            for(int x : arr){
                total += x ; 
            }
            return total ;
        }
        int windowSum = 0 ; 
        for(int i = 0 ; i < m ; i++){
            windowSum += arr.get(i); 
        }
        int max = windowSum ; 
        
        for(int i = 1 ; i < n ; i++){
            int addIdx = (i + m - 1) % n ; 
            int removeIdx = i - 1; 
            
            windowSum += arr.get(addIdx); 
            windowSum -= arr.get(removeIdx);
            max = Math.max(max , windowSum); 
        }
        return max; 
    }
}