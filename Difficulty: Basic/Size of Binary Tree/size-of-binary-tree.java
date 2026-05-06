/*
Definition for Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    public int getSize(Node node) {
        // code here
        if(node == null){
            return 0 ; 
        }
        int left = getSize(node.left);
        int right = getSize(node.right);
        return left + right + 1 ; 
    }
}