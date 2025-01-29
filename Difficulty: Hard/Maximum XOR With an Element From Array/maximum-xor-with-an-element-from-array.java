//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.ArrayList; 

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N=sc.nextInt();
            int Q=sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int [][]queries=new int[Q][2];
            for(int i=0;i<Q;i++){
                queries[i][0]=sc.nextInt();
                queries[i][1]=sc.nextInt();
            }
            
            Solution obj = new Solution();
            int ans[]= obj.maximumXor(N, Q, arr, queries);
            for(int i=0;i<ans.length;i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends



 class Node {
    Node links[];

    Node() {
        links = new Node[2]; // Binary Trie (0 and 1 only)
    }

    Node get(int n) {
        return links[n];
    }

    void put(int n, Node node) {
        links[n] = node;
    }

    boolean containsKey(int n) {
        return links[n] != null;
    }
}

 class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    void insert(int num) {
        Node temp = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!temp.containsKey(bit)) {
                temp.put(bit, new Node());
            }
            temp = temp.get(bit);
        }
    }

    int getMax(int num) {
        int maxNum = 0;
        Node temp = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (temp.containsKey(1 - bit)) {
                maxNum = maxNum | (1 << i);
                temp = temp.get(1 - bit);
            } else {
                temp = temp.get(bit);
            }
        }
        return maxNum;
    }
}

 class Solution {
    int[] maximumXor(int n, int Q, int arr[], int queries[][]) {
        int result[] = new int[Q];
        int queryWithIdx[][] = new int[Q][3];

        for (int i = 0; i < Q; i++) {
            queryWithIdx[i][0] = queries[i][0];
            queryWithIdx[i][1] = queries[i][1];
            queryWithIdx[i][2] = i;
        }

        // Sort queries by mi
        Arrays.sort(queryWithIdx, (a, b) -> Integer.compare(a[1], b[1]));

        // Sort the array
        Arrays.sort(arr);

        Trie obj = new Trie();
        int idx = 0;

        for (int[] query : queryWithIdx) {
            int xi = query[0];
            int mi = query[1];
            int index = query[2];

            // Insert all eligible numbers into the trie
            while (idx < arr.length && arr[idx] <= mi) {
                obj.insert(arr[idx]);
                idx++;
            }

            if (idx == 0) { // Empty trie case
                result[index] = -1;
            } else {
                result[index] = obj.getMax(xi);
            }
        }

        return result;
    }
}
