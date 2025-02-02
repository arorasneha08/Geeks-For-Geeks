//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java





class Solution {
    public void dfs(int row , int col , int[][] visited , ArrayList<ArrayList<Integer>> mat , ArrayList<String> res, String str){
        int n = mat.size();
        int m = mat.get(0).size() ; 
        if(row < 0 || row >= n || col < 0 || col >= m || visited[row][col] == 1 || mat.get(row).get(col) == 0){
            return  ; 
        }
        if(row == n-1 && col == m-1){
            res.add(str) ; 
            return ; 
        }
        visited[row][col] = 1 ; 
        dfs(row + 1 , col , visited , mat ,res ,  str + "D");
        dfs(row , col-1 , visited , mat , res , str + "L");
        dfs(row , col+1 , visited , mat , res , str + "R");
        dfs(row - 1 , col , visited , mat ,res , str + "U"); 
        
        visited[row][col] = 0 ; 
        
    }
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<String> list = new ArrayList<>(); 
        int n = mat.size();
        int m = mat.get(0).size() ; 
        if(mat.get(0).get(0) == 0 || mat.get(n-1).get(m-1) == 0) return list  ;
        int visited[][] = new int[n][m] ; 
        ArrayList<String> result = new ArrayList<>(); 
        dfs(0 , 0 , visited, mat , result , ""); 
        return result ;
    }
}