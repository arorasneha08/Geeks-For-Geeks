//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    class DisjointSet {
        List<Integer> rank ; 
        List<Integer> parent ; 
        DisjointSet(int n){
            rank = new ArrayList<>();
            parent = new ArrayList<>();
            
            for(int i = 0 ; i < n ; i++){
                rank.add(0);
                parent.add(i); 
            }
        }
        int findParent(int node){
            if(parent.get(node) == node) return node ;  
            int ul_parent = findParent(parent.get(node)); 
            parent.set(node , ul_parent);
            return parent.get(node) ; 
        }
        void unionByRank(int u , int v){
            int ul_u = findParent(u);
            int ul_v = findParent(v);
            if(ul_v == ul_u) return ; 
            if(rank.get(ul_u) < rank.get(ul_v)){
                parent.set(ul_u , ul_v); 
            }
            else if(rank.get(ul_u) > rank.get(ul_v)){
                parent.set(ul_v , ul_u) ;
            }
            else{
                parent.set(ul_v , ul_u); 
                rank.set(ul_u , rank.get(ul_u) +1) ; 
            }
        }
    }
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        DisjointSet ds = new DisjointSet(V); 
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1]; 
            if((u == c && v == d) ||( u == d && v == c)) continue;  
            ds.unionByRank(u , v) ;
        }
        return ds.findParent(c) != ds.findParent(d); 
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            // V and E on separate lines
            int V = Integer.parseInt(sc.nextLine().trim());
            int E = Integer.parseInt(sc.nextLine().trim());

            // Using a 2D array to store edges.
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                // Use split("\\s+") to handle one or more whitespace characters
                String[] parts = sc.nextLine().trim().split("\\s+");
                edges[i][0] = Integer.parseInt(parts[0]);
                edges[i][1] = Integer.parseInt(parts[1]);
            }

            // c and d on separate lines
            int c = Integer.parseInt(sc.nextLine().trim());
            int d = Integer.parseInt(sc.nextLine().trim());

            Solution obj = new Solution();
            boolean result = obj.isBridge(V, edges, c, d);
            System.out.println(result ? "true" : "false");
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends