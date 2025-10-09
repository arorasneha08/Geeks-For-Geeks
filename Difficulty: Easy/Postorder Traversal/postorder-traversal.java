/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    private void func(Node root , ArrayList<Integer> list){
        if(root == null) return ; 
        func(root.left , list); 
        func(root.right , list); 
        list.add(root.data); 
    }
    public ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> res = new ArrayList<>(); 
        if(root == null) return res;
        func(root , res) ; 
        return res; 
    }
}