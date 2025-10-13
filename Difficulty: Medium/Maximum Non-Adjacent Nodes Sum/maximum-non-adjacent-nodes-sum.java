/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    Map<Node , Integer> mpp = new HashMap<>(); 
    
    private int func(Node root){
        if(root == null) return 0 ; 
        if(mpp.containsKey(root)) return mpp.get(root); 
        
        int skip1 = func(root.left); 
        int skip2 = func(root.right); 
        
        int a = 0 , b = 0 , c = 0 , d = 0 ;
        if(root.left != null){
            a = func(root.left.left); 
            b = func(root.left.right); 
        }
        if(root.right != null){
            c = func(root.right.left); 
            d = func(root.right.right); 
        }
        int take = root.data + a + b + c + d ; 
        int nottake = skip1 + skip2 ; 
        int val = Math.max(take , nottake) ; 
        mpp.put(root , val); 
        return val ; 
    }
    public int getMaxSum(Node root) {
        if(root == null) return 0 ; 
        return func(root);
    }
}