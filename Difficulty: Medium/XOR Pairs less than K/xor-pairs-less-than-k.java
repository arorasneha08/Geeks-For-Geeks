class Solution {
    static class TrieNode {
        TrieNode[] child = new TrieNode[2]; // stores 0 and 1
        int count = 0; // number of values passing through this node
    }

    private static void insert(TrieNode root, int num) {
        TrieNode curr = root;
        for(int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(curr.child[bit] == null) {
                curr.child[bit] = new TrieNode();
            }
            curr = curr.child[bit];
            curr.count++;
        }
    }

    private static int countLessThan(TrieNode root, int num, int k) {
        TrieNode curr = root;
        int pairs = 0;

        for(int i = 31; i >= 0 && curr != null; i--) {
            int bitNum = (num >> i) & 1;
            int bitK = (k >> i) & 1;

            if(bitK == 1) {
                // Add all numbers matching bitNum branch
                if(curr.child[bitNum] != null) {
                    pairs += curr.child[bitNum].count;
                }
                // Move to the opposite branch
                curr = curr.child[1 - bitNum];
            } else {
                // Must follow same bit path
                curr = curr.child[bitNum];
            }
        }
        return pairs;
    }
    public int cntPairs(int[] arr, int k) {
        TrieNode root = new TrieNode();
        int result = 0;

        for(int num : arr) {
            result += countLessThan(root, num, k);
            insert(root, num);
        }
        return result;
    }
}
