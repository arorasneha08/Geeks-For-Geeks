/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    private Node reverse(Node head){
        Node curr = head ;
        Node prev = null ; 
        Node agla = null ;
        while(curr != null){
            agla = curr.next ; 
            curr.next = prev ; 
            prev = curr; 
            curr = agla ; 
        }
        return prev; 
    }
    private Node middle(Node head){
        Node slow = head; 
        Node fast = head ; 
        while(fast.next != null && fast.next.next != null){
            slow = slow.next ; 
            fast = fast.next.next; 
        }
        return slow ; 
    }
    public boolean isPalindrome(Node head) {
        if(head == null) return true ; 
        Node midd = middle(head); 
        Node next = midd.next; 
        midd.next = null ; 
        Node rev = reverse(next); 
        
        Node t1 = head; 
        Node t2 =  rev; 
        while(t1 != null && t2 != null){
            if(t1.data != t2.data){
                return false; 
            }
            t1 = t1.next; 
            t2 = t2.next ; 
        }
        return true; 
    }
}