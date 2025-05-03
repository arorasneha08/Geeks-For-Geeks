//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    Node primeList(Node head) {
        int prime[] = new int[11001] ; 
        Arrays.fill(prime , 1); 
        prime[0] = prime[1] = 0; 
        for(int i = 2 ; i * i <= 11000 ; i++){
            if(prime[i] == 1){
                for(int j = 2*i ; j<= 11000 ; j+= i){
                    prime[j] = 0 ; 
                }
            }
        }
        Node temp = head; 
        while(temp != null){
            int val = temp.val ; 
            if(val == 1){
                temp.val = 2 ; 
            }
            else if(prime[val] == 1){
                temp.val = val ; 
            }
            else{
                int left = val ; 
                int right = val ; 
                while(prime[left] == 0){
                    left -- ; 
                }
                while(prime[right] == 0){
                    right ++ ;
                }
                int leftDiff = Math.abs(val - left); 
                int rightDiff = Math.abs(val - right); 
                if(leftDiff <= rightDiff){
                    temp.val = left; 
                }
                else{
                    temp.val = right; 
                }
            }
            temp = temp.next ; 
        }
        return head; 
    }
}