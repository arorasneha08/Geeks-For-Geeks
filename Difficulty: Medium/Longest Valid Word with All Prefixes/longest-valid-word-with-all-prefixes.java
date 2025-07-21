class Solution {
    public class Node {
        Node links[] = new Node[26]; 
        boolean flag = false ; 
        Node() {} 
        
        boolean containsKey(char ch){
            return (links[ch - 'a'] != null); 
        }
        void put(char ch , Node node){
            links[ch - 'a'] = node;
        }
        Node get(char ch){
            return links[ch - 'a']; 
        }
        boolean isEnd(){
            return flag ; 
        }
        void setEnd(){
            flag = true; 
        }
        
    }
    public class Trie {
        Node root ; 
        
        Trie(){
            root = new Node(); 
        }
        void insert(String word){
            Node temp = root; 
            int n = word.length(); 
            for(int i = 0 ; i < n ; i++){
                char ch = word.charAt(i); 
                if(!temp.containsKey(ch)){
                    temp.put(ch , new Node());
                }
                temp = temp.get(ch); 
            }
            temp.setEnd(); 
        }
        boolean checkIfPrefixExists(String word){
            int n = word.length(); 
            Node temp = root; 
            for(int i = 0 ; i < n ; i++){
                char ch = word.charAt(i); 
                if(!temp.containsKey(ch)){
                    return false; 
                }
                temp = temp.get(ch); 
                if(!temp.isEnd()) return false;
            }
            return true; 
        }
        
    }
    public String longestValidWord(String[] words) {
        int n = words.length ; 
        Trie t = new Trie(); 
        for(String word : words){
            t.insert(word); 
        }
        String longest = "" ; 
        for(String word : words){
            if(t.checkIfPrefixExists(word)){
                if(word.length() > longest.length()){
                    longest = word ;
                }
                else if(word.length() == longest.length() && word.compareTo(longest) < 0){
                    longest = word; 
                }
            }
        }
        return longest; 
    }
}