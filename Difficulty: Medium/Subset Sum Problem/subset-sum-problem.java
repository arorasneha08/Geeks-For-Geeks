//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    static boolean func(int index ,  int target , int arr[] , Boolean dp[][]){
        if(target == 0) return true ;
        if(index == 0){
            if(arr[index] == target){
                return true; 
            }
            else return false; 
        }
        if(dp[index][target] != null) return dp[index][target]; 
        
        boolean notPick = func(index - 1 ,target , arr , dp);
        boolean pick = false; 
        if(target >= arr[index]){
            pick = func(index - 1 , target - arr[index] , arr , dp ); 
        }
        return dp[index][target] = (pick || notPick); 
    }
    static Boolean isSubsetSum(int arr[], int target) {
        // using memoisation :- 
        
        // int n = arr.length; 
        // Boolean dp[][] = new Boolean[n][target+1] ; 

        // return func(n-1 , target ,arr , dp); 
        
        // using tabulation :- 
        
        // int n = arr.length ; 
        // Boolean dp[][] = new Boolean[n][target+1];
        // for(Boolean row[] : dp){
        //     Arrays.fill(row , false); 
        // }
        
        // for(int i = 0 ; i< n ;i++){
        //     dp[i][0] = true ; 
        // }
        // if (arr[0] <= target) dp[0][arr[0]] = true;
        
        // for(int idx = 1 ; idx < n ;idx ++){
        //     for(int tar = 1 ; tar <= target ; tar++){
        //         boolean nottake = dp[idx-1][tar]; 
        //         boolean take = false; 
        //         if(arr[idx] <= tar){
        //             take = dp[idx-1][tar - arr[idx]];  
        //         }
        //         dp[idx][tar] = (take || nottake) ; 
        //     }
        // }
        // return dp[n-1][target]; 
        
        // using space optimisation :-
        
        int n = arr.length ; 
        Boolean prev[] = new Boolean[target+1];
        Boolean curr[] = new Boolean[target+1] ; 
        Arrays.fill(prev , false); 
        Arrays.fill(curr , false); 
        
        prev[0] = curr[0] = true; 

        if (arr[0] <= target) prev[arr[0]] = true;
        
        for(int idx = 1 ; idx < n ;idx ++){
            for(int tar = 1 ; tar <= target ; tar++){
                boolean nottake = prev[tar]; 
                boolean take = false; 
                if(arr[idx] <= tar){
                    take = prev[tar - arr[idx]];  
                }
                curr[tar] = (take || nottake) ; 
            }
            prev = curr.clone(); 
        }
        return prev[target]; 
    }
}