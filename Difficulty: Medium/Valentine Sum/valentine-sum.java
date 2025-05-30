//{ Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

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

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0){
            String line = br.readLine().trim();
            Node root = buildTree(line);
            
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int target = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            
            Solution x = new Solution();
            System.out.println( x.sum_at_distK(root, target, k) );
            t--;
        
System.out.println("~");
}
    }
}


// } Driver Code Ends


/*
// node structure:

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
    static void MarkParents(Node root , HashMap<Node , Node> mpp){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.left != null){
                mpp.put(curr.left, curr); 
                q.offer(curr.left); 
            }
            if(curr.right != null){
                mpp.put(curr.right , curr);
                q.offer(curr.right); 
            }
        }
        
    }
    static Node findTarget(Node root , int target){
        if(root == null) return null ; 
        if(root.data == target) return root ;
        Node left = findTarget(root.left , target);
        if(left != null) return left; 
        Node right = findTarget(root.right , target); 
        return right; 
    }
    static int sum_at_distK(Node root, int target, int k) {
        if(root == null) return  0 ;
        HashMap<Node , Node> mpp = new HashMap<>(); 
        Node tar = findTarget(root , target); 
        MarkParents(root, mpp); 
        Set<Node> visited = new HashSet();
        Queue<Node> q = new LinkedList<>(); 
        q.offer(tar);
        visited.add(tar); 
        int level = 0 ; 
        int sum = 0 ; 
        while(!q.isEmpty()){
            int size = q.size(); 
            if(level > k) break ; 
            for(int i = 0 ; i < size  ; i++){
                Node curr = q.poll();
                sum += curr.data; 
                if(curr.left != null && !visited.contains(curr.left)){
                    q.offer(curr.left); 
                    visited.add(curr.left); 
                }
                if(curr.right != null && !visited.contains(curr.right)){
                    q.offer(curr.right) ;
                    visited.add(curr.right); 
                }
                if(mpp.get(curr) != null && !visited.contains(mpp.get(curr))){
                    visited.add(mpp.get(curr)); 
                    q.offer(mpp.get(curr)); 
                }
            }
            level ++ ; 
        }
        return sum ; 
    }
}
