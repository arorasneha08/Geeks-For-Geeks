// User function Template for Java

/*
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
    static class CustomNode{
        Node node ;
        int col ;
        CustomNode(Node node , int col){
            this.node = node;
            this.col = col; 
        }
    }
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>(); 
        if(root == null){
            return ans; 
        }
        Queue<CustomNode> q = new LinkedList<>(); 
        q.offer(new CustomNode(root, 0));
        TreeMap<Integer , Integer> mpp = new TreeMap<>();
        
        while(!q.isEmpty()){
            CustomNode customNode = q.poll(); 
            Node node = customNode.node; 
            int col = customNode.col ; 
            if(!mpp.containsKey(col)){
                mpp.put(col, node.data); 
            }
            if(node.left != null){
                q.offer(new CustomNode(node.left , col-1)); 
            }
            if(node.right != null){
                q.offer(new CustomNode(node.right , col+1)); 
            }
        }
        for(Map.Entry<Integer, Integer> entry : mpp.entrySet()){
            ans.add(entry.getValue()); 
        }
        return ans ; 
    }
}
