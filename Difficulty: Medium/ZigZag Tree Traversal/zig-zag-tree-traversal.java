/*
class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
	    if(root == null) return ans ; 
	    Queue<Node> q = new LinkedList<>();
	    q.offer(root);
	    boolean reverse = false ;
	    
	    while(!q.isEmpty()){
	        ArrayList<Integer> level = new ArrayList<>() ; 
	        int size = q.size();
	        
	        for(int i = 0; i< size ; i++){
	            Node curr = q.poll() ; 
	            
	            level.add(curr.data); 
	            
	            if(curr.left != null){
	                q.offer(curr.left); 
	            }
	            if(curr.right != null){
	                q.offer(curr.right); 
	            }
	            
	        }
	        if(reverse) {
	           for(int j = level.size() - 1 ; j >= 0 ; j--){
	                ans.add(level.get(j)); 
	            }
	        }
	       else{
            ans.addAll(level) ; 
	       }
	       reverse = !reverse; 
	    }
	    return ans ; 
    }
}