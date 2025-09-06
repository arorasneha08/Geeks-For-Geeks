// User function Template for Java

/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution {
    private static Node merge(Node t1 , Node t2){
        Node d = new Node(-1); 
        Node temp = d ; 
        while(t1 != null && t2 != null){
            if(t1.data <= t2.data){
                temp.next = t1 ; 
                t1 = t1.next; 
            }
            else{
                temp.next = t2 ; 
                t2 = t2.next; 
            }
            temp = temp.next ; 
        }
        if(t1 != null){
            temp.next = t1; 
        }
        if(t2 != null){
            temp.next = t2 ; 
        }
        return d.next; 
    }
    private static Node middle(Node head){
        Node slow = head; 
        Node fast = head ; 
        while(fast.next != null && fast.next.next != null){
            slow = slow.next; 
            fast = fast.next.next ;
        }
        return slow; 
    }
    public static Node insertionSort(Node head) {
        if(head == null || head.next == null) return head; 
        Node midd = middle(head); 
        Node next = midd.next;
        midd.next = null;
        
        Node left = insertionSort(head); 
        Node right = insertionSort(next); 
        return merge(left, right); 
    }
}