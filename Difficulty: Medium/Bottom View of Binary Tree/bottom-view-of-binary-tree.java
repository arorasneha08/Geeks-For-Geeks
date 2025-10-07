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
    public class Pair{
        Node root ; 
        int idx ; 
        Pair(Node root , int idx){
            this.root = root; 
            this.idx = idx ; 
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> res = new ArrayList<>(); 
        if(root == null) return res ;
        TreeMap<Integer , Integer> mpp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>(); 
        q.offer(new Pair(root , 0));
        
        while(!q.isEmpty()){
            Pair curr = q.poll(); 
            Node node = curr.root;
            int idx = curr.idx;  
            mpp.put(idx , node.data); 
            
            if(node.left != null){
                q.offer(new Pair(node.left , idx - 1));
            }
            if(node.right != null){
                q.offer(new Pair(node.right, idx + 1)); 
            }
        }
        for(int val : mpp.values()){
            res.add(val); 
        }
        return res; 
    }
}