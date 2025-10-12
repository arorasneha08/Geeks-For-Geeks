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
    int count = 0 ; 
    private int func(Node root){
        if(root == null) return 0 ; 
        int left = func(root.left); 
        int right = func(root.right); 
        count += Math.abs(left) + Math.abs(right);  
        return root.data + left + right - 1; 
    }
    public int distCandy(Node root) {
        if(root == null) return -1; 
        func(root); 
        return count ; 
    }
}