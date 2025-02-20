//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static List<Integer> maxCombinations(int n, int k, int a[], int b[]) {
        List<Integer> res = new ArrayList<>();
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        
        HashSet<String> visited = new HashSet<>();
        
        pq.offer(new int[]{a[n - 1] + b[n - 1], n - 1, n - 1});
        visited.add((n - 1) + "," + (n - 1));

        while (k > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            res.add(top[0]);
            k--;

            int i = top[1], j = top[2];

            // Try adding the next largest pair in the row (i-1, j)
            if (i - 1 >= 0 && !visited.contains((i - 1) + "," + j)) {
                pq.offer(new int[]{a[i - 1] + b[j], i - 1, j});
                visited.add((i - 1) + "," + j);
            }

            // Try adding the next largest pair in the column (i, j-1)
            if (j - 1 >= 0 && !visited.contains(i + "," + (j - 1))) {
                pq.offer(new int[]{a[i] + b[j - 1], i, j - 1});
                visited.add(i + "," + (j - 1));
            }
        }

        return res;
    } 
}
