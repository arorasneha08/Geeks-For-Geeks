

/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    int maximum(Node node , int[] maxi){
        if(node == null) return 0 ; 
        int left = maximum(node.left , maxi);
        int right = maximum(node.right , maxi); 
        
        left = Math.max(0 , left);
        right = Math.max(0 , right);
        
        maxi[0] = Math.max(maxi[0] , left + right + node.data);
        
        return Math.max(left , right) + node.data; 
    }
    int findMaxSum(Node node) {
        int maxi[] = new int[1];
        maxi[0] = Integer.MIN_VALUE ; 
        maximum(node , maxi);
        return maxi[0] ; 
    }
}
