//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            // The mergeOverlap function now returns a List<int[]>
            List<int[]> ans = obj.mergeOverlap(arr);

            // Printing the merged arr
            for (int[] interval : ans) {
                System.out.print(interval[0] + " " + interval[1] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        int n = arr.length ; 
        List<int[]> ans = new ArrayList<>(); 
        Arrays.sort(arr , (a,b) -> Integer.compare(a[0] , b[0])); 
        
        for(int i = 0 ; i<n ; i++){
            if(ans.isEmpty() || arr[i][0] > ans.get(ans.size()-1)[1]) {
                ans.add(arr[i]); 
            }
            else if(arr[i][1]> ans.get(ans.size()-1)[0]){
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1] , arr[i][1]); 
            }
        }
        return ans ; 
    }
}