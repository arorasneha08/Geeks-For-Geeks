// User function Template for Java

class Solution {
    private static void buildTree(int idx ,  int low , int high , int st[], int arr[]){
        if(low == high){
            st[idx] = arr[low] ;
            return ; 
        }
        int mid = low + (high - low)/2; 
        buildTree(2 * idx + 1 , low , mid , st , arr); 
        buildTree(2 * idx + 2 , mid + 1 , high , st , arr); 
        st[idx] = gcd(st[2 * idx + 1 ] , st[2 * idx + 2]); 
    }
    private static int gcd(int x , int y){
        if(y == 0) return x;  
        return gcd(y , x % y); 
    }
    public static int findRangeGcd(int l, int r, int st[], int n) {
        return query(0 , 0 , n-1 , l, r, st); 
    }
    private static int query(int idx , int low , int high , int left , int right , int st[]){
        if(high < left || right < low) return 0 ; 
        if(left <= low && high <= right){
            return st[idx]; 
        }
        int mid = low + (high - low)/2 ; 
        return gcd(query(2 * idx + 1 , low , mid , left , right , st) , query(2 * idx + 2 , mid + 1 , high , left , right , st));
    }

    public static void updateValue(int index, int new_val, int arr[], int st[], int n) {
        update(0 , 0 , n-1 , index , new_val , st); 
        arr[index] = new_val ; 
    }
    private static void update(int idx , int low , int high , int pos , int val, int st[]){
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
        st[idx] = gcd(st[2 * idx + 1 ] , st[2 * idx + 2]); 
    }
}
