

/*
class of the node of the tree is as
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
// complete this function
// return true/false if the is Symmetric or not
class Solution {
    public static boolean helper(Node left , Node right){
        if(left == null && right == null){
            return true ; 
        }
        if(left == null || right == null){
            return false ; 
        }
        if(left.data != right.data){
            return false ; 
        }
        return (helper(left.left , right.right) && helper(left.right , right.left)); 
    }
    public static boolean isSymmetric(Node root) {
        return helper(root.left , root.right); 
    }
}