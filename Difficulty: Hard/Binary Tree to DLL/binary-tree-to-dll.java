//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}
class BT_To_DLL
{
    
    static Node buildTree(String str)throws IOException{
        
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
    

	void inorder(Node node)
	{
		if(node==null)
			return ;
		else
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
	}
	public static void printList(Node head) 
    {
		Node prev = head;
        while (head != null) 
        {
            System.out.print(head.data + " ");
			prev = head;
            head = head.right;
        }
		
		System.out.println();
		while(prev != null)
		{
			System.out.print(prev.data+" ");
			prev = prev.left;
		}
    }
	public static void main(String args[])  throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
			    
			    Node ans = g.bToDLL(root);
			    printList(ans);
                t--;
                System.out.println();
	        
System.out.println("~");
}
			
		
	}
}

// } Driver Code Ends


// User function Template for Java

/* class Node
class Node
{
    Node left, right;
    int data;

    Node(int d)
    {
        data = d;
        left = right = null;
    }

}*/

// This function should return head to the DLL

class Solution {
    void inorderTraversal(Node root, List<Integer> res){
        if(root == null) return ; 
        inorderTraversal(root.left , res);
        res.add(root.data);
        inorderTraversal(root.right, res); 
    }
    
    Node d = new Node(-1) ;
    Node curr = d ; 
    
    void func(Node root){
        if(root == null) return ; 
        func(root.left) ;
        
        curr.right = root ; 
        root.left = curr; 
        curr = root ; 
        
        func(root.right) ; 
    }
    Node bToDLL(Node root) {
        // if(root == null) return root; 
        // List<Integer> res = new ArrayList<>(); 
        // inorderTraversal(root, res); 
        // Node head = new Node(res.get(0)); 
        // Node temp = head; 
        // for(int i = 1 ; i< res.size() ; i++){
        //     Node node = new Node(res.get(i)); 
        //     temp.right = node; 
        //     node.left = temp; 
        //     temp = node; 
        // }
        // return head; 
        func(root); 
        Node head = d.right ; 
        if(head != null){
            head.left = null;
        }
        return head; 
    }
}