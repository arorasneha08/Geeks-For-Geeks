//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private static void dfs(int node , int visited[] ,ArrayList<ArrayList<Integer>> adj, int V){
        visited[node] = 1;  
        
        for(int i = 0 ; i < V ; i++){
            if(visited[i] == 0 && adj.get(node).get(i) == 1){
                visited[i] = 1; 
                dfs(i , visited , adj , V); 
            } 
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        int count = 0 ; 
        int visited[] = new int[V]; 
        for(int i = 0 ; i < V ; i++){
            if(visited[i] == 0){
                count ++ ; 
                dfs(i , visited , adj, V); 
            }
        }
        return count; 
    }
};