//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxXor(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    class Node{
        Node links[]= new Node[26];
        boolean flag = false ;
        
        boolean containsKey(int n){
            return (links[n] != null) ; 
        }
        Node get(int n){
            return links[n] ; 
        }
        void put(int n , Node node){
            links[n] = node; 
        }
    }
    class Trie{
        Node root ;
        
        Trie(){
            root = new Node(); 
        }
        void insert(int num){
            Node temp = root; 
            for(int i = 31 ; i>= 0 ; i--){
                int bit = (num >> i) & 1 ; 
                if(!temp.containsKey(bit)){
                    temp.put(bit , new Node()); 
                }
                temp = temp.get(bit); 
            }
        }
        int getMax(int num){
            Node temp = root;  
            int maxNum = 0 ; 
            for(int i = 31 ; i>= 0 ; i--){
                int bit = (num >> i) & 1 ; 
                if(temp.containsKey(1-bit)){
                    maxNum = maxNum | (1 << i) ; 
                    temp = temp.get(1 - bit); 
                }
                else{
                    temp = temp.get(bit); 
                }
            }
            return maxNum ; 
        }
    }
    public int maxXor(int[] arr) {
         Trie obj = new Trie();
         int n = arr.length ;
        for(int i = 0 ; i < n ; i++){
            obj.insert(arr[i]) ; 
        }
        int xor = 0 ;
        for(int i = 0 ; i<n ; i++){
            xor = Math.max(xor , obj.getMax(arr[i])); 
        }
        return xor ; 
        
    }
}