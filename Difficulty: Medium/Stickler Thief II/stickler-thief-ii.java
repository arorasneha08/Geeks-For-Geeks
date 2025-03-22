//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] arr = IntArray.input(br);

            Solution obj = new Solution();
            int res = obj.maxValue(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends





class Solution {
    public int robAdj(int nums[]){
        int n = nums.length ; 
        int prev = nums[0];
        int prev2 = 0 ;
        for(int i = 1 ; i< n ; i++){
            int pick = nums[i] ;
            if(i > 1){
                pick += prev2; 
            }
            int notpick = prev ; 
            int curr = Math.max(pick , notpick); 
            prev2 = prev ; 
            prev = curr ; 
        }
        return prev ; 
    }
    int maxValue(int[] arr) {
        int n = arr.length ; 
        int a1[] = new int[n-1];
        int a2[] = new int[n-1]; 
        for(int i = 0 ; i < n ; i++){
            if(i != 0){
                a1[i-1] = arr[i] ; 
            }
            if(i != n-1){
                a2[i] = arr[i] ; 
            }
        }
        return Math.max(robAdj(a1) , robAdj(a2)); 
    }
}
