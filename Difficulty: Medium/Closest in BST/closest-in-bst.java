/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int minDiff(Node root, int k) {
        // code here
        if(root == null) return Integer.MAX_VALUE;
        if(root.data == k){
            return 0 ; 
        }
        
        if(root.data < k){
            return Math.min(k - root.data , minDiff(root.right , k));
        }
        else{
            return Math.min(root.data - k , minDiff(root.left, k));
        }
    }
}