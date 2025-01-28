//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPermutation(String s) {
        int n = s.length() ;
        Set<String> set = new HashSet<>();
        char ch[] = s.toCharArray();
        generatePermuation(ch , 0 , set); 
        return new ArrayList<>(set); 
    }
    public void generatePermuation(char[] chars , int index , Set<String> set){
        if(index == chars.length){
            set.add(new String(chars)); 
            return ; 
        }
        for(int i = index ; i < chars.length ; i++){
            swap(chars , index , i);
            generatePermuation(chars , index + 1 , set); 
            swap(chars , index , i);
        }
    }
    public void swap(char[] ch , int left , int right){
        char temp = ch[left];
        ch[left] = ch[right] ;
        ch[right] = temp; 
    }
}