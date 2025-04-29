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

/* class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}*/
class Solution {
    static Node segregate(Node head) {
        if(head == null) return null ;
        Node one = new Node(-1);
        Node two = new Node(-1); 
        Node zero = new Node(-1); 
        Node zeroHead = zero ; 
        Node oneHead = one;
        Node twoHead = two; 
        Node temp = head; 
        while(temp != null){
            if(temp.data == 0){
                zero.next = temp ; 
                zero = zero.next ; 
            }
            else if(temp.data == 1){
                one.next = temp ; 
                one = one.next; 
            }
            else {
                two.next = temp; 
                two = two.next ; 
            }
            temp = temp.next ; 
        }
        two.next = null ;
        if(oneHead.next != null){
            zero.next = oneHead.next ;
        }
        else{
            zero.next = twoHead.next ; 
        }
        one.next = twoHead.next ; 
        return zeroHead.next ; 
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
            head = new Solution().segregate(head);
            printList(head);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends