/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public Node sortedInsert(Node head, int data) {
        Node node = new Node(data);
        if(head == null) {
            node.next = node; 
            return node; 
        }
        Node curr = head ;
        
        // inseret at head 
        if(data <= curr.data){
            while(curr.next != head){
                curr = curr.next; 
            }
            curr.next = node; 
            node.next = head; 
            return node; 
        }
        // insert in middle 
        while(curr.next != head && curr.next.data < data){
            curr = curr.next ; 
        }
        node.next = curr.next ; 
        curr.next = node; 
        return head; 
    }
}