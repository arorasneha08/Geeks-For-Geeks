//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline character after reading the integer

        while (t-- > 0) {
            String input = sc.nextLine();
            String[] inputArray = input.split(" ");
            int[] arr = new int[inputArray.length];

            for (int i = 0; i < inputArray.length; i++) {
                arr[i] = Integer.parseInt(inputArray[i]);
            }

            int target = sc.nextInt();
            if (sc.hasNextLine())
                sc.nextLine(); // consume the newline after reading target

            Solution obj = new Solution();
            System.out.println(obj.numberOfSubarrays(arr, target));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int helper(int arr[] , int k , int n){
        int left = 0 ; 
        int count = 0 ;
        int sum = 0 ; 
        
        for(int right = 0 ; right < n ; right ++){
            
            sum += arr[right]; 
            
            while(sum > k){
                sum -= arr[left];
                left ++ ;
            }
            
            count += (right - left + 1); 
        }
        return count ; 
    }
    public int numberOfSubarrays(int[] arr, int target) {
        int n = arr.length ;
        return helper(arr, target , n) - helper(arr, target - 1 , n); 
    }
}