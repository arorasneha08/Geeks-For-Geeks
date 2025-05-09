//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    private String max;

    private void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private void solve(int index, char[] arr, int k) {
        if (k == 0 || index >= arr.length) return;

        char maxChar = arr[index];
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] > maxChar) {
                maxChar = arr[i];
            }
        }

        if (maxChar != arr[index]) {
            k--;
        }

        for (int i = arr.length - 1; i >= index; i--) {
            if (arr[i] == maxChar) {
                swap(arr, index, i);
                String curr = new String(arr);
                if (curr.compareTo(max) > 0) {
                    max = curr;
                }
                solve(index + 1, arr, k);
                swap(arr, index, i);
            }
        }
    }

    public String findMaximumNum(String s, int k) {
        max = s;
        solve(0, s.toCharArray(), k);
        return max;
    }
}
