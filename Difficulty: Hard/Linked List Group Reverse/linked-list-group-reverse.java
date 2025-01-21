//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class ReverseInSize {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < s.length; i++) {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverseKGroup(head, k);
            printList(res, out);
            out.println();

            out.println("~");
        }
        out.close();
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
    }
}

// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node reverse(Node temp){
        Node prev = null;
        Node agla = null ;
        Node curr = temp;
        while(curr != null){
            agla = curr.next ;
            curr.next = prev ;
            prev = curr; 
            curr = agla ;
        }
        return prev ; 
    }
    public static Node findKthNode(Node temp , int k){
        while(temp != null && k > 1){
            k--;
            temp = temp.next; 
        }
        return temp ; 
    }
    public static Node reverseKGroup(Node head, int k) {
        Node temp = head ;
        Node prevNode = null ;
        Node nextNode = null; 
        while(temp != null){
            Node kthNode = findKthNode(temp , k);
            if(kthNode == null){
                Node reverseHead = reverse(temp); 
                if(prevNode != null){
                    prevNode.next = reverseHead ;
                }
                break ; 
            }
            nextNode = kthNode.next ; 
            kthNode.next = null;
            reverse(temp);
            if(temp == head){
                head = kthNode; 
            }
            else{
                prevNode.next = kthNode ; 
            }
            prevNode = temp; 
            temp = nextNode; 
        }
        return head; 
    }
}
