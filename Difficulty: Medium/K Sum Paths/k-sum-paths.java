/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int dfs(Node root , int sum , HashMap<Integer, Integer> mpp , int target){
        if(root == null) return 0 ;
        sum += root.data ; 
        
        int count = mpp.getOrDefault(sum - target , 0); 
        
        mpp.put(sum , mpp.getOrDefault(sum , 0) + 1); 
        
        count += dfs(root.left , sum , mpp , target);
        count += dfs(root.right , sum , mpp , target);
        
        mpp.put(sum , mpp.get(sum)-1);
        return count ; 
    }
    public int countAllPaths(Node root, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1); 
        return dfs(root , 0 ,  mpp , k); 
    }
}