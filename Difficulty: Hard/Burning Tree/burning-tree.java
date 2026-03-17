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
    private Node findTarget(Node root , int target){
        if(root == null) return null ; 
        if(root.data == target) return root ; 
        
        Node left = findTarget(root.left , target); 
        if(left != null) return left; 
        
        return findTarget(root.right , target); 
    }
    
    private void markParent(Node root , HashMap<Node, Node> mpp){
        Queue<Node> q = new LinkedList<>(); 
        q.offer(root); 
        
        while(!q.isEmpty()){
            Node curr = q.poll(); 
            if(curr.left != null){
                mpp.put(curr.left , curr);
                q.offer(curr.left); 
            }
            if(curr.right != null){
                mpp.put(curr.right , curr); 
                q.offer(curr.right); 
            }
        }
    }
    
    public int minTime(Node root, int target) {
        if(root == null) return 0 ; 
        int time = 0 ; 
        HashMap<Node , Node> mpp = new HashMap<>();
        Node tar = findTarget(root , target); 
        markParent(root , mpp); 
        
        Queue<Node> q = new LinkedList<>();
        q.offer(tar);
        
        Map<Node, Boolean> visited = new HashMap<>();
        visited.put(tar , true) ; 
        
        while(!q.isEmpty()){
            boolean burn = false; 
            int size = q.size(); 
            
            for(int i = 0 ; i < size ; i++){
                Node curr = q.poll();
                
                if(curr.left != null && visited.get(curr.left) == null){
                    burn = true ;
                    visited.put(curr.left , true); 
                    q.offer(curr.left); 
                }
                
                if(curr.right != null && visited.get(curr.right) == null){
                    burn = true; 
                    visited.put(curr.right , true);
                    q.offer(curr.right); 
                }
                
                if(mpp.get(curr) != null && visited.get(mpp.get(curr)) == null){
                    visited.put(mpp.get(curr), true);
                    q.offer(mpp.get(curr)); 
                    burn = true; 
                }
            }
            
            if(burn) time ++ ;  
        }
        
        return time; 
    }
}