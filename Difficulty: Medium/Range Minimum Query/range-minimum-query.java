/* The functions which
builds the segment tree */
class GfG {
    static int st[];

    public static int[] constructST(int arr[], int n) {
        st = new int[4 * n];
        buildTree(0 , 0 , n-1, arr); 
        return st ; 
    }
    private static void buildTree(int idx , int low , int high , int arr[]){
        if(low == high){
            st[idx] = arr[low]; 
            return ; 
        }
        int mid = low + (high - low)/2; 
        buildTree(2 * idx + 1 , low , mid , arr); 
        buildTree(2 * idx + 2 , mid + 1 , high , arr); 
        
        st[idx] = Math.min(st[2 * idx + 1] , st[2 * idx + 2]); 
    }
    public static int RMQ(int st[], int n, int l, int r) {
        return query(0 , 0 , n-1 , l , r); 
    }
    private static int query(int idx , int low , int high , int left , int right){
        if(high < left || right < low) return Integer.MAX_VALUE;
        if(left <= low && right >= high){
            return st[idx]; 
        }
        int mid = low + (high - low)/2 ; 
        return Math.min(query(2 * idx + 1 , low , mid , left , right) ,query(2 * idx + 2 , mid + 1 , high , left , right)); 
        
    }
}