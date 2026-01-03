// User function Template for Java

class Solution {
    Node merge(Node l1 , Node l2 ){
        Node d = new Node(-1);
        Node res = d ;
        while(l1 != null && l2 != null){
            if(l1.data < l2.data){
                res.bottom = l1 ;
                res = l1 ;  
                l1 = l1.bottom; 
            }
            else{
                res.bottom = l2 ;
                res = l2; 
                l2 = l2.bottom ; 
            }
            res.next = null ; 
        }
        if(l1 != null){
            res.bottom = l1;
        }
        else{
            res.bottom = l2 ; 
        }
        return d.bottom; 
    }
    Node flatten(Node root) {
        if(root == null || root.next == null){
            return root ; 
        }
        Node mergedHead = flatten(root.next);
        root = merge(root , mergedHead);
        return root; 
    }
}
