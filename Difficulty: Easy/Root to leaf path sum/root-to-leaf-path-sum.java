/*
// A Binary Tree node
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    private boolean func(Node root , int sum , int target){
        if(root == null) return false ; 
        
        if(root.left == null && root.right == null){
            sum += root.data; 
            if(sum == target) return true; 
            return false; 
        }
        
        boolean left = func(root.left , sum + root.data , target); 
        boolean right = func(root.right , sum + root.data , target); 
        
        return left || right; 
    }
    boolean hasPathSum(Node root, int target) {
        return func(root , 0 , target); 
    }
}