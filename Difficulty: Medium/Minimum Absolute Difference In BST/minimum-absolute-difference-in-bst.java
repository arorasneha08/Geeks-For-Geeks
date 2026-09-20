/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int prev = -1;
    int minDiff = Integer.MAX_VALUE;

    public int absDiff(Node root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != -1) {
            minDiff = Math.min(minDiff, root.data - prev);
        }

        prev = root.data;

        inorder(root.right);
    }
}