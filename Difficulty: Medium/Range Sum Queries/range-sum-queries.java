// User function Template for Java

class Sol {
    // arr : given array
    // n : size of arr
    // index : need to update
    // new_val : given value to which we need to update index
    // st : constructed segment-tree

    // Function to update a value in input array and segment tree.
    
    static void updateValue(int arr[], long st[], int n, int index, int val) {
            
        update(0 , 0 , n-1, st , index , val); 
        arr[index] = val; 
    }
    static void update(int idx , int low , int high , long segmentTree[], int pos , int val){
        if(low == high){
            segmentTree[idx] = val ; 
            return ; 
        }
        int mid = low + (high - low)/2; 
        if(pos <= mid){
            update(2 * idx + 1 , low , mid , segmentTree , pos , val);      
        }
        else{
            update(2 * idx + 2 , mid + 1 , high , segmentTree, pos , val); 
        }
        segmentTree[idx] = segmentTree[2 * idx + 1] + segmentTree[2 * idx + 2]; 
    }
    private static void buildTree(int idx , int low , int high , int arr[] , long st[]){
        if(low == high){
            st[idx] = arr[low];
            return ; 
        }
        int mid = low + (high - low)/2 ; 
        buildTree(2 * idx + 1 , low , mid , arr, st); 
        buildTree(2 * idx + 2 , mid + 1 , high , arr , st); 
        
        st[idx] = st[2 * idx + 1] + st[2 * idx + 2] ;
    }

    // Function to return sum of elements in range from index qs (query start)
    // to qe (query end).
    public static long getSum(long st[], int n, int l, int r) {
        return query(0 , 0 , n-1 , l , r , st); 
    }
    public static long query(int idx , int low , int high , int left , int right , long st[]){
        if(high < left || right < low) return 0 ; 
        if(left <= low && high <= right) {
            return st[idx]; 
        }
        int mid = low + (high - low)/2; 
        return query(2 * idx + 1 , low , mid , left , right , st) + query(2 * idx + 2 , mid + 1 , high , left , right , st); 
    }
}