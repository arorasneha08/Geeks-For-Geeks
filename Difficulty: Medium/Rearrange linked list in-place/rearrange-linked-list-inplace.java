//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends

/*
The structure of linked list is the following

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
    private Node reverse(Node head){
        Node curr = head;
        Node prev = null ;
        Node agla = null; 
        while(curr != null){
            agla = curr.next ; 
            curr.next = prev ; 
            prev = curr; 
            curr  = agla  ;
        }
        return prev; 
    }
    private Node middle(Node head){
        Node slow = head; 
        Node fast = head; 
        while(fast.next != null && fast.next.next != null){
            slow = slow.next; 
            fast = fast.next.next; 
        }
        return slow; 
    }
    public Node inPlace(Node head) {
        if (head == null || head.next == null) return head;

        Node mid = middle(head);

        Node second = reverse(mid.next);
        mid.next = null;  

        Node first = head;
        while (second != null) {
            Node temp1 = first.next;
            Node temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }

        return head;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
        System.out.println("~");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }

            Solution ob = new Solution();
            Node ans = ob.inPlace(head);
            printList(ans);
        }
    }
}

// } Driver Code Ends