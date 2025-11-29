/*Complete The given function
The Node class is as follows:
class Node{
    int data;
    Node left,right;

    Node(int d)
     {
      data=d;
      left=null;
      right=null;
    }
}*/
class Solution {
    public ArrayList<Integer> extremeNodes(Node root) {
        ArrayList<Integer> res = new ArrayList<>(); 
        if(root == null) return res ; 
        Queue<Node> q = new LinkedList<>(); 
        q.offer(root); 
        boolean flag = true; 
        
        while(!q.isEmpty()){
            int size = q.size(); 
            
            for(int i = 0 ; i < size ; i++){
                Node curr = q.poll(); 
                if(flag){
                    if(i == size-1){
                        res.add(curr.data); 
                    }
                }
                else{
                    if(i == 0){
                        res.add(curr.data); 
                    }
                }
                
                if(curr.left != null){
                    q.offer(curr.left); 
                }
                if(curr.right != null){
                    q.offer(curr.right); 
                }
            }
            flag = !flag  ; 
        }
        return res; 
    }
}