//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            String res = obj.longestString(n, arr);
            
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    public class Node{
        Node links[] ; 
        boolean flag ; 
        
        Node(){
            links = new Node[26]; 
            flag = false; 
        }
        
        boolean containsKey(char ch){
            return (links[ch - 'a'] != null); 
        }
        Node get(char ch){
            return links[ch - 'a']; 
        }
        void put(char ch , Node node){
            links[ch - 'a'] = node; 
        }
        void setEnd(){
            flag = true; 
        }
        boolean isEnd(){
            return flag ; 
        }
        
    }
    public class Trie{
        Node root ;
        Trie(){
            root = new Node(); 
        }
        
        public void insert(String word){
            Node temp = root ; 
            int n = word.length() ;
            for(int i = 0 ; i < n ; i++){
                if(!temp.containsKey(word.charAt(i))){
                    temp.put(word.charAt(i) , new Node()); 
                }
                temp = temp.get(word.charAt(i)); 
            }
            temp.setEnd() ; 
        }
        public boolean  checkIfPrefixExists(String word){
            Node temp = root ;
            int n = word.length() ;
            for(int i = 0 ; i< word.length() ; i++){
                char ch = word.charAt(i) ; 
                if(temp.containsKey(ch)){
                    temp = temp.get(ch); 
                    if(!temp.isEnd()) return false; 
                }
                else{
                    return false ; 
                }
            }
            return true ; 
        }
    }
    public  String longestString(int n, String[] arr) {
        Trie obj = new Trie();
        for(int i = 0 ; i < n ; i++){
            obj.insert(arr[i]); 
        }
        String longest  = "" ;  
        for(int i = 0 ; i< n ; i++){
            if(obj.checkIfPrefixExists(arr[i])){
                if(arr[i].length() > longest.length()){
                    longest = arr[i] ; 
                }
                if((arr[i].length() == longest.length() )&& (arr[i].compareTo(longest) < 0)){
                    longest = arr[i] ; 
                }
            }
        }
        return longest ; 
    }
}
        
