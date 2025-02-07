//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution{
    private int timer = 1 ; 
    public void dfs(int node , int parent , int[] visited , int[] tin , int[] low, int[] mark , ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1 ; 
        tin[node] = low[node] = timer;  
        timer ++ ; 
        int child = 0 ; 
        for(int adjNode : adj.get(node)){
            if(adjNode == parent) continue;  
            if(visited[adjNode] == 0){
                dfs(adjNode , node , visited, tin , low , mark, adj) ; 
                low[node] = Math.min(low[node] , low[adjNode]); 
                
                if(low[adjNode] >= tin[node] && parent != -1){
                    mark[node] = 1; 
                }
                child ++ ; 
            }
            else{
                low[node] = Math.min(low[node] , tin[adjNode]); 
            }
        }
        if(child > 1 && parent == -1){
            mark[node] = 1 ;
        }
    }
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj){
        int visited[] = new int[V];
        int tin[] = new int[V];
        int mark[] = new int[V];
        int low[] = new int[V]; 
        
        for(int i = 0 ; i < V ; i++){
            if(visited[i] == 0){
                dfs( i , -1 ,  visited, tin , low , mark , adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            if(mark[i] == 1){
                ans.add(i); 
            }
        }
        if(ans.size() == 0){
            ans.add(-1); 
        }
        return ans ; 
    }
}