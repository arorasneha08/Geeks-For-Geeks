class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {
        int res[] = new int[3] ; 
        int n = a.length ; 
        int m = b.length ; 
        int o = c.length ;
        int best = Integer.MAX_VALUE ; 
        int i = 0 , j = 0 , k = 0 ; 
        Arrays.sort(a); 
        Arrays.sort(b); 
        Arrays.sort(c); 
        
        while(i < n && j < m && k < o){
            int min = Math.min(a[i] , Math.min(b[j] , c[k])); 
            int max = Math.max(a[i] , Math.max(b[j] , c[k])); 
            
            if(max - min < best){
                best = max - min ; 
                res[0] = a[i]; 
                res[1] = b[j]; 
                res[2] = c[k]; 
            }
            if(min == a[i]) i++; 
            else if(min == b[j]) j++; 
            else k++; 
        }
        Arrays.sort(res); 
        int left = 0 ;
        int right = 2;  
        while(left <= right){
            int temp = res[left]; 
            res[left] = res[right] ;
            res[right] = temp ;
            left ++; 
            right --; 
        }
        return res; 
    }
}
