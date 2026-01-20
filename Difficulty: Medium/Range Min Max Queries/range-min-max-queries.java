class Solution {
    // Returns a vector<int> of size 2 where:
    // [0] = minimum value in arr from index L to R (inclusive),
    // [1] = maximum value in arr from index L to R (inclusive).
    // Uses the prebuilt segTree where each node stores [min, max].
    // Segment tree indexing:
    // - For a node at idx, left child is at 2*idx + 1, right child at 2*idx + 2.
    public int[] getMinMax(int[] arr, int L, int R, int[][] segTree) {
        return query(0 , 0 , arr.length-1 , L , R, segTree); 
    }
    public int[] query(int idx , int low , int high , int left , int right , int st[][]){
        if(high < left || right < low ) return new int[]{Integer.MAX_VALUE , Integer.MIN_VALUE} ; 
        if(left <= low && high <= right) return st[idx]; 
        int mid = low + (high - low)/2 ; 
        int[] q1 = query(2 * idx + 1, low, mid, left, right, st);
        int[] q2 = query(2 * idx + 2, mid + 1, high, left, right, st);

        return new int[]{Math.min(q1[0], q2[0]),Math.max(q1[1], q2[1])};
    }

    // Updates the value at arr[index] to 'value' and updates the segTree accordingly.
    // Uses the prebuilt segTree where each node stores [min, max].
    // Segment tree indexing:
    // - For a node at idx, left child is at 2*idx + 1, right child at 2*idx + 2.
    public void updateValue(int[] arr, int index, int value, int[][] segTree) {
        update(0 , 0 , arr.length-1 , index , value , segTree); 
        arr[index] = value ; 
    }
    private void update(int idx , int low , int high , int pos , int val , int segTree[][]){
        if(low == high){
            segTree[idx][0] = val; 
            segTree[idx][1] = val; 
            return ; 
        }
        int mid = low + (high - low)/2 ; 
        if(pos <= mid){
            update(2 * idx + 1 , low , mid , pos , val , segTree); 
        }
        else{
            update(2 * idx + 2 , mid + 1 , high , pos , val , segTree); 
        }
        segTree[idx][0] = Math.min(segTree[2 * idx + 1][0] , segTree[2 * idx + 2][0]) ; 
        segTree[idx][1] = Math.max(segTree[2 * idx + 1][1] , segTree[2 * idx + 2][1]) ;
    }
};