// User function Template for Java

/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution {
    private static Node reverse(Node head){
        Node curr = head ;
        Node prev = null; 
        Node agla = null; 
        while(curr != null){
            agla = curr.next ; 
            curr.next = prev ; 
            prev = curr; 
            curr = agla ; 
        }
        return prev; 
    }
    public static Node reverseBetween(int a, int b, Node head) {
        if(head == null) return null; 
        int count = 1 ; 
        Node temp = head;
        Node a1 = null; 
        Node b1 = null; 
        Node prev = null; 
        if(a == b) return head ; 
        while(temp != null){
            if(count == a-1){
                prev = temp ; 
            }
            else if(count == a){
                a1 = temp ; 
            }
            else if(count == b){
                b1 = temp ; 
            }
            count ++; 
            temp = temp.next ; 
        }
        Node nextNode = b1.next ; 
        b1.next = null; 
        Node rev = reverse(a1); 
        if(prev != null){
            prev.next = rev ; 
        }
        else{
            head = rev ; 
        }
        a1.next = nextNode ; 
        return head; 
    }
}