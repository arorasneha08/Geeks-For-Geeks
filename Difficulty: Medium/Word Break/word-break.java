//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            String line = sc.nextLine();
            String[] dictionary = line.split(" ");

            Solution obj = new Solution();
            if (obj.wordBreak(s, dictionary)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    private boolean func(String s , String[] dictionary){
        boolean dp[] = new boolean[s.length()+1]; 
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        dp[0] = true; 
        
        int maxWordLength = 0;
        for (String word : dictionary) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }
        
        for(int i = 1 ; i <= s.length() ; i++){
            for(int j = Math.max(i - maxWordLength , 0); j < i ; j++){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true; 
                    break ; 
                }
            }
        }
        return dp[s.length()]; 
    }
    public boolean wordBreak(String s, String[] dictionary) {
        int n = s.length();
        return func(s, dictionary); 
    }
}