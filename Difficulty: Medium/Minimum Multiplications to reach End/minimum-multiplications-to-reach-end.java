//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        int mod = 100000;
        
        // If start is already equal to end, return 0 steps
        if (start == end) return 0;

        // Queue for BFS: stores (currentValue, steps)
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});

        // Visited array to avoid cycles
        boolean[] visited = new boolean[mod];
        visited[start] = true;

        // BFS traversal
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int steps = current[1];

            // Try multiplying with each number in arr
            for (int num : arr) {
                int newValue = (value * num) % mod;

                // If we reach the target, return the steps count
                if (newValue == end) {
                    return steps + 1;
                }

                // If newValue is not visited, enqueue it
                if (!visited[newValue]) {
                    visited[newValue] = true;
                    queue.offer(new int[]{newValue, steps + 1});
                }
            }
        }

        // If end is never reached, return -1
        return -1;

    }
}
