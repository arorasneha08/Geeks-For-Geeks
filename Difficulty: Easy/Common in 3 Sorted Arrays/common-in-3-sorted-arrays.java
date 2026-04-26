class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        ArrayList<Integer> res = new ArrayList<>(); 
        int i = 0 , j = 0 , k = 0 ;
        
        while(i < a.length && j < b.length && k < c.length){
            int x = a[i] , y = b[j] , z = c[k]; 
            if(x == y && y == z){
                if(res.isEmpty() || res.get(res.size()-1) != x){
                    res.add(x); 
                }
                i++ ;
                j++ ; 
                k++ ; 
            }
            else{
                int min = Math.min(x , Math.min(y , z)); 
                if(x == min) i++ ; 
                if(y == min) j++ ;
                if(z == min) k++ ;
            }
        }
        return res ; 
    }
}