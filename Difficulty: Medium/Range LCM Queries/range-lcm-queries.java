// User function Template for Java

class Solution {
    private static long gcd(long x , long y){
        if(y == 0) return x;  
        return gcd(y , x % y); 
    }
    private static long lcm(long x , long y){
        return x * y / gcd(x,y) ; 
    }
    private static long query(int idx , int low , int high , int left , int right , long st[]){
        if(high < left || right < low) return 0 ; 
        if(left <= low && high <= right){
            return st[idx]; 
        }
        int mid = low + (high - low)/2 ; 
        return lcm(query(2 * idx + 1 , low , mid , left , right , st) , query(2 * idx + 2 , mid + 1 , high , left , right , st));
    }
    public static long getLCM(long st[], long arr[], int n, int qs, int qe) {
        return query(0 , 0 , n-1 , qs, qe, st); 
    }

    public static void updateValue(long arr[], long st[], int n, int index, long new_val) {
        update(0 , 0 , n-1 , index , new_val , st); 
        arr[index] = new_val ; 
    }
    private static void update(int idx , int low , int high , int pos , long val, long st[]){
        if(low == high){
            st[idx] = val; 
            return; 
        }
        int mid = low + (high - low)/2;  
        if(pos <= mid){
            update(2 * idx + 1 , low , mid , pos , val , st); 
        }
        else{
            update(2 * idx + 2 , mid + 1 , high , pos , val , st); 
        }
        st[idx] = lcm(st[2 * idx + 1 ] , st[2 * idx + 2]); 
    }
}