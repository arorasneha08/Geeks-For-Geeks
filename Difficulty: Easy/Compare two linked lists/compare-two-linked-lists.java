//{ Driver Code Starts
import java.util.*;

// Linked list Node structure
class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }
}

public class Main {
    // Function to compare two linked lists lexicographically
    static int compare(Node list1, Node list2) {
        while (list1 != null && list2 != null && list1.data == list2.data) {
            list1 = list1.next;
            list2 = list2.next;
        }
        if (list1 != null && list2 != null) {
            return (list1.data > list2.data) ? 1 : -1;
        }
        if (list1 != null && list2 == null) return 1;
        if (list1 == null && list2 != null) return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume newline character after reading integer

        while (t-- > 0) {
            // End of test case, compare and clear lists
            Node list1 = null, list2 = null;

            // Read first list
            String line = scanner.nextLine();
            Scanner iss1 = new Scanner(line);
            char x = iss1.next().charAt(0);
            Node temp1 = new Node(x);
            list1 = temp1;
            Node current1 = temp1;

            while (iss1.hasNext()) {
                x = iss1.next().charAt(0);
                Node newNode = new Node(x);
                current1.next = newNode;
                current1 = newNode;
            }

            // Read second list
            line = scanner.nextLine();
            Scanner iss2 = new Scanner(line);
            x = iss2.next().charAt(0);
            Node temp2 = new Node(x);
            list2 = temp2;
            Node current2 = temp2;

            while (iss2.hasNext()) {
                x = iss2.next().charAt(0);
                Node newNode = new Node(x);
                current2.next = newNode;
                current2 = newNode;
            }
            // Compare lists
            Solution obj = new Solution();
            System.out.println(obj.compare(list1, list2));

            // Clean up memory (Java does this automatically with garbage collection)
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


/*  Structure of Node
class Node
 {
    char data;
    Node next;

    // Constructor to create a new node
    Node(char d)
    {
       data = d;
       next = null;
    }
 }*/

class Solution {
    int compare(Node head1, Node head2) {
        Node t1 = head1 ;
        Node t2 = head2 ;
        while(t1 != null && t2 != null){
            int val1 = t1.data - 'a';
            int val2 = t2.data - 'a';
            if(val1 < val2){
                return -1 ; 
            }
            else if(val1 > val2){
                return 1; 
            }
            t1 = t1.next; 
            t2 = t2.next; 
        }
        if(t1 == null && t2 != null){
            return -1; 
        }
        if(t2 == null && t1 != null){
            return 1 ; 
        }
        return 0 ; 
    }
}