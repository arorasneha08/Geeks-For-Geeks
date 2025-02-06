//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to find number of strongly connected components in the graph.
    private void dfs(int node , int[] visited , Stack<Integer> st , ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        for (int adjNode : adj.get(node)) {
            if (visited[adjNode] == 0) {
                dfs(adjNode, visited, st, adj);
            }
        }
        st.push(node);
    }

    private void dfs2(int node, int[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> adjRev) {
        visited[node] = 1;
        for (int adjNode : adjRev.get(node)) {  // Fixed incorrect adjacency reference
            if (visited[adjNode] == 0) {
                dfs2(adjNode, visited, st, adjRev);
            }
        }
        st.push(node);
    }

    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int visited[] = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, st, adj);
            }
        }

        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjRev.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int adjNode : adj.get(i)) { 
                adjRev.get(adjNode).add(i);
            }
        }

        Arrays.fill(visited, 0);

        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (visited[node] == 0) { 
                scc++;
                Stack<Integer> tempStack = new Stack<>();
                dfs2(node, visited, tempStack, adjRev);
            }
        }
        return scc;
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            System.out.println(obj.kosaraju(adj));

            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends