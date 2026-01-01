/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        if(head1 == null || head2 == null) return null; 
        Node t1 = head1 ; 
        Node t2 = head2 ; 
        while(t1 != t2){
            if(t1 == null){
                t1 = head2 ; 
            }
            else{
                t1 = t1.next; 
            }
            if(t2 == null){
                t2 = head1 ; 
            }
            else{
                t2 = t2.next; 
            }
        }
        return t1; 
    }
}