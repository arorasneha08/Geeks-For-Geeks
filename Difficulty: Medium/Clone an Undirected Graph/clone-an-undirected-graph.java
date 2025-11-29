// User function Template for Java

/*
    class Node{
        int val;
        ArrayList<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }
*/
class Solution {
    private Node dfs(Node node , HashMap<Node , Node> mpp){
        if(mpp.containsKey(node)){
            return mpp.get(node) ; 
        }
        Node clone = new Node(node.val); 
        mpp.put(node , clone); 
        
        for(Node adjNode : node.neighbors){
            clone.neighbors.add(dfs(adjNode , mpp)); 
        }
        return clone; 
    }
    Node cloneGraph(Node node) {
        if(node == null) return null; 
        return dfs(node , new HashMap<Node , Node>()); 
    }
}