/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public class Pair implements Comparable<Pair>{
        int val ;
        int diff ; 
        Pair(int val , int diff){
            this.val = val ; 
            this.diff = diff; 
        }
        public int compareTo(Pair other){
            if(this.diff == other.diff){
                return this.val - other.val ;
            }
            return this.diff - other.diff ; 
        }
    }
    public void func(Node root , PriorityQueue<Pair> pq , int target){
        if(root == null) return ; 
        func(root.left , pq, target); 
        pq.offer(new Pair(root.data , Math.abs(root.data - target)));
        func(root.right , pq ,target); 
    }
    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        ArrayList<Integer> res = new ArrayList<>(); 
        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        func(root , pq, target); 
        while(!pq.isEmpty() && k > 0){
            Pair curr = pq.poll(); 
            int val = curr.val ;
            res.add(val); 
            k-- ; 
        }
        return res;
    }
}