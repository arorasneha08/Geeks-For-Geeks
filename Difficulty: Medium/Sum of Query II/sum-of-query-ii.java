// User function Template for Java

class Solution {
    public void buildTree(int idx , int low , int high , int segmentTree[], int arr[]){
        if(low == high){
            segmentTree[idx] = arr[low]; 
            return ; 
        }
        int mid = low + (high - low)/2; 
        buildTree(2 * idx + 1 , low , mid , segmentTree , arr); 
        buildTree(2 * idx + 2 , mid + 1 , high , segmentTree , arr); 
        
        segmentTree[idx] = segmentTree[2 * idx + 1] + segmentTree[2 * idx + 2];
    }
    public int query(int idx , int low , int high , int left , int right , int segmentTree[]){
        if(left <= low && high <= right){
            return segmentTree[idx];
        }
        if(right < low || high < left) return 0 ; 
        int mid = low + (high - low)/2 ; 
        return query(2 * idx + 1 , low , mid , left , right , segmentTree) + 
        query(2 * idx + 2 , mid + 1 , high , left , right , segmentTree); 
    }
    List<Integer> querySum(int n, int arr[], int q, int queries[]) {
        List<Integer> res  = new ArrayList<>(); 
        int segmentTree[] = new int[4 * n] ; 
        buildTree(0 , 0 , n-1, segmentTree , arr);
        
        for(int i = 0 ; i < queries.length - 1; i+=2){
            int a = queries[i] - 1; 
            int b = queries[i+1] - 1; 
            res.add(query(0 , 0 , n-1 , a , b, segmentTree));
        }
        return res ; 
    }
}