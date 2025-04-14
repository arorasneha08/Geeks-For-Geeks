//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {
    private List<Integer> toposort(int n , List<List<Integer>> adj){
        int indegree[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            for(int adjNode : adj.get(i)){
                indegree[adjNode] ++; 
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0){
                q.offer(i); 
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            res.add(curr);
            for(int adjNode : adj.get(curr)){
                indegree[adjNode] --; 
                if(indegree[adjNode] == 0){
                    q.offer(adjNode); 
                }
            }
        }
        return res; 
    }
    public String findOrder(String[] words) {
        int n = words.length ; 
        int k = 26 ;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < k ; i++){
            adj.add(new ArrayList<>());
        }
        boolean present[] = new boolean[k];
        for(String word : words){
            for(char ch : word.toCharArray()){
                present[ch - 'a'] = true ; 
            }
        }
        for(int i = 0 ; i < n - 1 ; i++){
            String s1 = words[i];
            String s2 = words[i+1];
            if(s1.length() > s2.length() && s1.startsWith(s2)){
                return ""; 
            }
            int len = Math.min(s1.length() , s2.length()); 
            for(int j = 0 ; j < len ; j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a'); 
                    break ; 
                }
            }
        }
        
        List<Integer> topo = toposort(k, adj);
        StringBuilder str = new StringBuilder();
        for(int ch : topo){
            if(present[ch]){
                str.append((char)(ch+ 'a')); 
            }
        }
        int count = 0 ;  
        for(boolean b : present){
            if(b){
                count ++ ; 
            }
        }
        if(count == str.length()) return str.toString();
        return "" ; 
    }
}



//{ Driver Code Starts.

public class GFG {
    private static boolean validate(String[] original, String order) {
        Map<Character, Integer> mp = new HashMap<>();
        for (String word : original) {
            for (char ch : word.toCharArray()) {
                mp.put(ch, 1);
            }
        }
        for (char ch : order.toCharArray()) {
            if (!mp.containsKey(ch)) {
                return false;
            }
            mp.remove(ch);
        }
        if (!mp.isEmpty()) {
            return false;
        }

        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            indexMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < original.length - 1; i++) {
            String a = original[i];
            String b = original[i + 1];
            int k = 0, n = a.length(), m = b.length();

            while (k < n && k < m && a.charAt(k) == b.charAt(k)) {
                k++;
            }

            if (k < n && k < m &&
                indexMap.get(a.charAt(k)) > indexMap.get(b.charAt(k))) {
                return false;
            }
            if (k != n && k == m) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); // Number of test cases

        while (t-- > 0) {
            String[] words = sc.nextLine().split(" ");
            String[] original = Arrays.copyOf(words, words.length);

            Solution ob = new Solution();
            String order = ob.findOrder(words);

            if (order.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(validate(original, order) ? "true" : "false");
            }
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends