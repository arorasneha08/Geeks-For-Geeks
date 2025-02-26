//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends



class Solution {
    public int[] findpse(int arr[]) {
        int n = arr.length;
        int pse[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }

    // Function to find Next Smaller Element (NSE)
    public int[] findnse(int arr[]) {
        int n = arr.length;
        int nse[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    // Function to find max of mins for every window size
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] result = new int[n + 1]; // Array instead of ArrayList
        int[] nse = findnse(arr);
        int[] pse = findpse(arr);

        // Step 1: Compute max of min for each window size
        for (int i = 0; i < n; i++) {
            int windowSize = nse[i] - pse[i] - 1;
            result[windowSize] = Math.max(result[windowSize], arr[i]);
        }

        // Step 2: Fill missing values by trickling down max values
        for (int i = n - 1; i > 0; i--) {
            result[i] = Math.max(result[i], result[i + 1]);
        }

        // Step 3: Convert result array to ArrayList and return
        ArrayList<Integer> finalResult = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            finalResult.add(result[i]);
        }

        return finalResult;
}
}