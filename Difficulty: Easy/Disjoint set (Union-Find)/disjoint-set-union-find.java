//{ Driver Code Starts
import java.util.*;

class Disjoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) a[i] = i;
            int k = sc.nextInt();
            GfG g = new GfG();
            for (int i = 0; i < k; i++) {
                String s = sc.next();
                if (s.equals("UNION")) {
                    int x = sc.nextInt();
                    int z = sc.nextInt();
                    g.unionSet(a, x, z);
                } else {
                    int x = sc.nextInt();
                    int parent = g.find(a, x);
                    System.out.print(parent + " ");
                }
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    int find(int par[], int x) {
        if(par[x] == x) return x ; 
        int ul_parent = find(par, par[x]);
        par[x] = ul_parent;
        return ul_parent ; 
    }

    void unionSet(int par[], int x, int z) {
        int rank[] = new int[par.length]; 
        int ul_parent_x = find(par , x);
        int ul_parent_z = find(par , z) ;
        
        if(ul_parent_x == ul_parent_z) return; 
        if(rank[ul_parent_x] > rank[ul_parent_z]){
            par[ul_parent_z] = ul_parent_x ; 
        }
        else if(rank[ul_parent_x] < rank[ul_parent_z]){
            par[ul_parent_x] = ul_parent_z ; 
        }
        else{
            par[ul_parent_x] = ul_parent_z ; 
            rank[ul_parent_z] = rank[ul_parent_z] + 1 ; 
        }
    }
}
