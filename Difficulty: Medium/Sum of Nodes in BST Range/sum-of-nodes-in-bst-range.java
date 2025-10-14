/*
class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    int sum = 0 ; 
    private void func(Node root , int l , int r){
        if(root == null) return ; 
        if(root.data >= l && root.data <= r){
            sum += root.data ; 
        }
        
        func(root.left , l,r);
        func(root.right , l , r); 
    }
    public int nodeSum(Node root, int l, int r) {
        if(root == null) return 0 ;
        // sum = 0 ; 
        func(root , l, r); 
        return sum ; 
    }
}
