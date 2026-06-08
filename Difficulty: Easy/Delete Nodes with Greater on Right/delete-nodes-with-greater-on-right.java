/* Structure of linked list node
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
    Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node next;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    Node compute(Node head) {
        Node newHead = reverse(head);
        int max = -1;
        
        Node temp = newHead;
        Node dummy = new Node(-1);
        Node curr = dummy;
        
        while(temp != null) {
            int val = temp.data;
            
            if(val >= max) {
                curr.next = temp;
                curr = curr.next;
            }
            
            max = Math.max(max, val);
            temp = temp.next;
            
        }
        
        curr.next = null;
        
        return reverse(dummy.next);
    }
}