// User function Template for Java

/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node divide(Node head) {
        Node temp = head ; 
        Node evenHead = new Node(-1); 
        Node oddHead = new Node(-1); 
        Node odd = oddHead ; 
        Node even = evenHead ; 
        while(temp != null){
            if(temp.data % 2 == 0){
                even.next = temp ; 
                even = even.next ; 
            }
            else{
                odd.next = temp ; 
                odd = odd.next ; 
            }
            temp = temp.next ; 
        }
        odd.next = null; 
        even.next = oddHead.next ;
        return evenHead.next ; 
    }
}