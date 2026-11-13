/* Structure of a Binary Search Tree node
class Node {
  public int data;
  public Node left;
  public Node right;

  public Node(int val) {
      data = val;
      left = right = null;
  }
};
*/

class Solution {
    public ArrayList<Integer> findCommon(Node r1, Node r2) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        while(r1!=null){
            st1.push(r1);
            r1 = r1.left;
        }
        while(r2!=null){
            st2.push(r2);
            r2 = r2.left;
        }
        while(!st1.isEmpty() && !st2.isEmpty()){
            Node top1 = st1.peek();
            Node top2 = st2.peek();
            if(top1.data == top2.data){
                ans.add(top1.data);
                r1 = top1.right;
                r2 = top2.right;
                st1.pop();
                st2.pop();
            }
            else if(top1.data<top2.data){
                r1 = top1.right;
                st1.pop();
            }
            else {
                r2 = top2.right;
                st2.pop();
            }

            while(r1!=null){
                st1.push(r1);
                r1 = r1.left;
            }
            while(r2!=null){
                st2.push(r2);
                r2 = r2.left;
            }
        }
        return ans;
    }
}

