/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
} */
class Solution {
    int res = -1 ; 
    private void func(Node root , int k){
        if(root == null) return  ; 
        if(root.data == k) {
            res = root.data; 
            return ; 
        }
        
        if(root.data < k){
            res = root.data; 
            func(root.right , k); 
        }
        else{
            func(root.left , k); 
        }
        
    }
    public int findMaxFork(Node root, int k) {
        if(root == null) return 0; 
        func(root , k);
        return res; 
    }
}