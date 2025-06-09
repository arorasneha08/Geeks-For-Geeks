/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
    private boolean func(Node root , int min , int max){
        if(root == null) return false; 
        if(root.left == null && root.right == null){
            if(min == max) return true; 
            return false; 
        }
        return func(root.left, min , root.data - 1) || func(root.right ,root.data + 1 , max); 
    }
    public boolean isDeadEnd(Node root) {
        return func(root , 1, (int) 1e9); 
    }
}