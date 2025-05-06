//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            Node head1 = null, tail1 = null;
            Node head2 = null, tail2 = null;

            String input1 = sc.nextLine();
            String[] elems1 = input1.split(" ");
            for (String elem : elems1) {
                Node newNode = new Node(Integer.parseInt(elem));
                if (head1 == null) {
                    head1 = newNode;
                    tail1 = newNode;
                } else {
                    tail1.next = newNode;
                    tail1 = newNode;
                }
            }

            String input2 = sc.nextLine();
            String[] elems2 = input2.split(" ");
            for (String elem : elems2) {
                Node newNode = new Node(Integer.parseInt(elem));
                if (head2 == null) {
                    head2 = newNode;
                    tail2 = newNode;
                } else {
                    tail2.next = newNode;
                    tail2 = newNode;
                }
            }

            Solution obj = new Solution();

            Node result = obj.mergeResult(head1, head2);
            printList(result);
        }
        sc.close();
    }
}

// } Driver Code Ends


/* Structure of the node*/
/* class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
} */

class Solution {
    private Node reverse(Node head){
        Node prev = null ;
        Node agla = null ; 
        Node curr = head; 
        while(curr != null){
            agla = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = agla; 
        }
        return prev; 
    }
    Node mergeResult(Node node1, Node node2) {
        Node t1 = (node1 != null) ? reverse(node1) : null;
        Node t2 = (node2 != null) ? reverse(node2) : null;
        Node d = new Node(-1) ;
        Node temp = d; 
        
        while(t1 != null && t2 != null){
            if(t1.data > t2.data){
                temp.next = t1 ; 
                t1 = t1.next; 
            }
            else{
                temp.next = t2; 
                t2 = t2.next; 
            }
            temp = temp.next; 
        }
        if(t1 != null){
            temp.next = t1;  
        }
        if(t2 != null){
            temp.next = t2; 
        }
        return d.next; 
    }
}
