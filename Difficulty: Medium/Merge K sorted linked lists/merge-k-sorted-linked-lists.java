/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node mergeKLists(Node[] arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        for(int i = 0 ; i< arr.length ; i++){
            pq.offer(arr[i]); 
        }
        Node head = null ;
        Node tail = null;
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            if(temp.next != null){
                pq.offer(temp.next); 
            }
            if(head == null){
                head = temp ; 
                tail = temp; 
            }
            else{
                tail.next = temp; 
                tail = temp ; 
            }
        }
        return head;  
    }
}