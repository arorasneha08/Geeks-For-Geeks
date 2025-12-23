class Solution {
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> res = new ArrayList<>(); 
        int n = arr.length ; 
        int max = 0 ;
        for(int i = 0; i < n ; i ++){
            max = Math.max(max , arr[i]); 
        }
        int pref[] = new int[max + 2] ;
        for(int i = 0 ; i < n ; i ++){
            pref[arr[i]] ++ ; 
        }
        for(int i = 1 ; i <= max ; i ++){
            pref[i] += pref[i - 1]; 
        }
        for(int q[] : queries){
            int a = q[0] ;
            int b = q[1] ; 
            
            if(a > max) {
                res.add(0); 
                continue; 
            } 
            if(b > max) b = max; 
            int val1 = (a > 0) ? pref[a-1] : 0; 
            int val2 = pref[b]; 
            res.add(val2 - val1); 
        }
        return res; 
    }
}
