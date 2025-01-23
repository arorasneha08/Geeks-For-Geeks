//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList<Integer> res = T.boundaryTraversal(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public boolean isLeaf(Node node){
        return (node.left == null && node.right == null); 
    }
    public void insertLeftBoundary(ArrayList<Integer> res, Node root){
        Node leftNode = root.left ;
        while(leftNode != null){
            if(isLeaf(leftNode)){
                break ; 
            }
            res.add(leftNode.data);
            if(leftNode.left != null){
                leftNode = leftNode.left; 
            }
            else{
                leftNode = leftNode.right ; 
            }
        }
    }
    public void insertRightBoundary(ArrayList<Integer> res, Node root){
        Node rightNode = root.right ; 
        Stack<Integer> st = new Stack<>(); 
        while(rightNode != null){
            if(isLeaf(rightNode)){
                break ;
            }
            st.push(rightNode.data); 
            if(rightNode.right != null){
                rightNode = rightNode.right ;
            }
            else{
                rightNode = rightNode.left ; 
            }
        }
        while(!st.isEmpty()){
            res.add(st.pop()); 
        }
    }
    public void insertLeafNode(ArrayList<Integer> res , Node root){
        if(root == null){
            return ; 
        }
        if(isLeaf(root)){
            res.add(root.data); 
        }
        insertLeafNode(res, root.left);
        insertLeafNode(res, root.right); 
    }
    public ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> res = new ArrayList<>(); 
        
        if(!isLeaf(node)){
            res.add(node.data); 
        }
        
        insertLeftBoundary(res, node);
        insertLeafNode(res, node); 
        insertRightBoundary(res, node); 
        return res; 
    }
}
