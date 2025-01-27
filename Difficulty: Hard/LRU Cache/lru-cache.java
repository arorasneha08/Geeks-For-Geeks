//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class LRUCache {
     class Node{
        Node prev ;
        Node next ; 
        int key ;
        int val ; 
        Node(int key , int val){
            this.key = key ;
            this.val = val ; 
        }
    }
    Node head ; 
    Node tail ; 
    int capacity ;
    HashMap<Integer, Node> mpp ;  
    
    LRUCache(int cap) {
        head = new Node(0,0); 
        tail = new Node(0,0);
        capacity = cap ; 
        mpp = new HashMap<>(); 
        head.next = tail ;
        tail.prev = head ; 
    }
    
    public void addFront(Node node){
        Node afterHead = head.next ; 
        head.next = node; 
        node.prev = head ;
        node.next = afterHead ;
        afterHead.prev = node; 
    }
    public void removeEnd(Node node){
        Node prevNode = node.prev ;
        Node nextNode = node.next ; 
        prevNode.next = nextNode;
        nextNode.prev = prevNode; 
    }
    
    public int get(int key) {
        if(mpp.containsKey(key)){
            Node value = mpp.get(key); 
            removeEnd(value) ;
            addFront(value); 
            return value.val ; 
        }
        return -1; 
    }

    public void put(int key, int value) {
        if(mpp.containsKey(key)){
            Node temp = mpp.get(key);
            temp.val = value; 
            removeEnd(temp); 
            addFront(temp) ; 
        }
        else{
            Node newNode = new Node(key , value) ;
            mpp.put(key , newNode);
            addFront(newNode); 
            
            if(mpp.size() > capacity){
                Node tailNode = tail.prev ; 
                removeEnd(tailNode); 
                mpp.remove(tailNode.key); 
            }
        }
    }
}
