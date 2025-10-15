/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    int count = 0 ; 
    int res = -1 ; 
    public void func(Node root , int k){
        if(root == null) return ; 
        
        func(root.left , k); 
        count ++; 
        if(count == k){
            res = root.data ; 
        }
        
        func(root.right , k); 
    }
    public int kthSmallest(Node root, int k) {
        if(root == null) return -1 ;
        func(root , k); 
        return res; 
    }
}