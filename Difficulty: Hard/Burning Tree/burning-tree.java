//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

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

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            int target = Integer.parseInt(br.readLine());
            Node root = buildTree(s);

            Solution g = new Solution();
            System.out.println(g.minTime(root, target));
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


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
}  */
class Solution {
    private static Node findTarget(Node root , int target){
        if(root == null) return null; 
        if(root.data == target) return root; 
        Node left = findTarget(root.left, target);
        if(left != null){
            return left; 
        }
        return findTarget(root.right , target); 
    }
    private static void markParents(Node root , HashMap<Node , Node> mpp){
        if(root == null) return ; 
        Queue<Node> q = new LinkedList<>();
        q.offer(root); 
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.left != null){
                mpp.put(curr.left , curr); 
                q.offer(curr.left); 
            }
            if(curr.right != null){
                q.offer(curr.right) ;
                mpp.put(curr.right , curr); 
            }
        }
    }
    public static int minTime(Node root, int target) {
        if(root == null) return 0 ; 
        HashMap<Node , Node> mpp = new HashMap<>();
        Node tar = findTarget(root , target); 
        markParents(root , mpp); 
        Queue<Node> q = new LinkedList<>();
        q.offer(tar);
        Map<Node, Boolean> visited = new HashMap<>();
        int time = 0 ; 
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