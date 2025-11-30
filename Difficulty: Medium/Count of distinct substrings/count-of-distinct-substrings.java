class Solution {
    public static class Node{
        Node links[] = new Node[26]; 
        boolean flag = false; 
        
        boolean containsKey(char ch){
            return (links[ch - 'a'] != null) ;  
        }
        Node get(char ch){
            return links[ch - 'a'] ; 
        }
        void put(char ch , Node node){
            links[ch - 'a'] = node; 
        }
    }
   public static int countSubs(String s){
        int count = 0 ; 
        int n = s.length(); 
        Node root =  new Node(); 
        for(int i = 0 ; i < n; i++){
            Node node = root; 
            for(int j = i ; j< n ; j++){
                if(!node.containsKey(s.charAt(j))){
                    count ++ ; 
                    node.put(s.charAt(j), new Node()); 
                }
                node = node.get(s.charAt(j)); 
            }
        }
        return count; 
   }
}