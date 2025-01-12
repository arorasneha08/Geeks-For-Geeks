//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        int n = arr.length ; 
        int left = 0 , right = n-1 ; 
        int leftMax = 0 , rightMax = 0 ; 
        int ans = 0 ; 
        while(left < right){
            if(arr[left] > leftMax){
                leftMax = Math.max(leftMax, arr[left]);
            }
            if(arr[right] > rightMax){
                rightMax = Math.max(rightMax, arr[right]); 
            }
            if(leftMax < rightMax){
                ans += (leftMax - arr[left]); 
                left ++ ; 
            }
            else {
                ans += (rightMax - arr[right]);
                right -- ; 
            }
        }
        return ans ; 
    }
}
