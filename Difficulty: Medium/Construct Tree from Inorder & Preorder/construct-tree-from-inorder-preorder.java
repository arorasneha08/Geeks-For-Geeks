//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    public static Node helper(int inorder[] , int preorder[] , int prestart , int preend , int instart , int inend ,Map<Integer , Integer> inMap){ 
        if(instart > inend || prestart > preend) return null;
        Node root = new Node(preorder[prestart]);
        int inroot = inMap.get(root.data);
        int numsLeft = inroot - instart ; 
        
        root.left = helper(inorder, preorder , prestart+1 , prestart + numsLeft , instart , inroot - 1 , inMap); 
        root.right = helper(inorder , preorder , prestart + numsLeft + 1 , preend , inroot + 1 , inend , inMap); 
        
        return root; 
    }
    public static Node buildTree(int inorder[], int preorder[]) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0 ; i<inorder.length ; i++){
            inMap.put(inorder[i] , i) ; 
        }
        return helper(inorder , preorder , 0, preorder.length -1 , 0 , inorder.length -1 , inMap); 
    }
}
