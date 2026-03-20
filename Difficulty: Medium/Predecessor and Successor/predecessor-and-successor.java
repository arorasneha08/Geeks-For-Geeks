

/* BST Node
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} */

class Solution {
    private void func(Node root , Node[] pre, Node[] succ , int target){
        while(root != null){
            if(target < root.data){
                succ[0] = root; 
                root = root.left;
            }
            else if(target > root.data){
                pre[0] = root ; 
                root = root.right; 
            }
            else{
                if(root.left != null){
                    Node temp = root.left; 
                    while(temp.right != null){
                        temp = temp.right ;
                    }
                    pre[0] = temp; 
                }
                if(root.right != null){
                    Node temp = root.right ;
                    while(temp.left != null){
                        temp = temp.left; 
                    }
                    succ[0] = temp ; 
                }
                break ;
            }
        }
    }
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> res = new ArrayList<>(); 
            Node pre[] = new Node[1] ;
        Node succ[] = new Node[1] ;
        func(root , pre, succ , key); 
        res.add(pre[0]);
        res.add(succ[0]); 
        return res; 
    }
}