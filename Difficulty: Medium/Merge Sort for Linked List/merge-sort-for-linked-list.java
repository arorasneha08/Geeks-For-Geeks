/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/

class Solution {
    private Node merge(Node t1 , Node t2){
        Node d = new Node(-1); 
        Node temp = d ; 
        while(t1 != null && t2 != null){
            if(t1.data < t2.data){
                temp.next = t1 ; 
                t1 = t1.next ;
            }
            else{
                temp.next = t2 ; 
                t2 = t2.next ; 
            }
            temp = temp.next ; 
        }
        if(t1 != null){
            temp.next = t1 ; 
        }
        if(t2 != null){
            temp.next = t2 ; 
        }
        return d.next ; 
    }
    
    private Node middle(Node head){
        Node slow = head ; 
        Node fast = head ; 
        while(fast.next != null && fast.next.next != null){
            slow = slow.next ; 
            fast = fast.next.next ; 
        }
        return slow; 
    }
    
    public Node mergeSort(Node head) {
        if(head == null || head.next == null) return head; 
        Node midd = middle(head); 
        Node nextNode = midd.next; 
        midd.next = null ; 
        
        Node left = mergeSort(head); 
        Node right = mergeSort(nextNode); 
        return merge(left , right);
    }
}