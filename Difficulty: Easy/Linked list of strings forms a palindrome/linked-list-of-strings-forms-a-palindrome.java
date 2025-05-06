//{ Driver Code Starts
import java.util.*;

class Node {
    String data;
    Node next;

    Node(String x) {
        data = x;
        next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() { head = null; }

    void addNode(String str) {
        if (head == null) {
            head = new Node(str);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(str);
        }
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int K = sc.nextInt();
            LinkedList list = new LinkedList();

            for (int i = 0; i < K; i++) {
                String str = sc.next();
                list.addNode(str);
            }

            Solution ob = new Solution();
            boolean ans = ob.compute(list.head);
            if (ans) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        
System.out.println("~");
}
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    private boolean isPalindrome(String str){
        int n = str.length();
        int left =  0 ; 
        int right = n-1; 
        
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false; 
            }
            left ++ ; 
            right -- ; 
        }
        return true; 
    }
    public boolean compute(Node root) {
        String str = "" ;
        Node temp = root; 
        while(temp != null){
            str += temp.data ; 
            temp = temp.next; 
        }
        return isPalindrome(str); 
    }
}