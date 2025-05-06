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

class Rearr {
    static Node head;

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node copy = head;
            for (int i = 1; i < s.length; i++) {
                Node temp = new Node(Integer.parseInt(s[i]));
                copy.next = temp;
                copy = copy.next;
            }
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
            System.out.println("~");
        }
    }

    public static void printLast(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
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
}*/
class Solution {
    private static Node reverse(Node head){
        Node curr = head ; 
        Node prev = null ;
        Node agla = null ;
        while(curr != null){
            agla = curr.next; 
            curr.next = prev ; 
            prev = curr;
            curr = agla; 
        }
        return prev ; 
    }
    public static void rearrange(Node head) {
        if(head == null || head.next == null) return; 
        Node d = new Node(-1);
        Node oddHead = head; 
        Node odd = oddHead ; 
        Node evenHead = head.next;
        Node even = evenHead; 
        Node temp = d; 
        while(even != null && even.next != null){
            odd.next = odd.next.next; 
            even.next = even.next.next;
            odd = odd.next; 
            even = even.next; 
        }
        Node rev = reverse(evenHead);
        temp.next = oddHead; 
        odd.next = rev; 
    }
}
