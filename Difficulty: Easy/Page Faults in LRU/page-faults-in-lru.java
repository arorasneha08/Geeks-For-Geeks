//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int pages[]= new int[N];
            for(int i = 0; i < N; i++)
                pages[i] = Integer.parseInt(input_line[i]);
            int C = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.pageFaults(N, C, pages));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution{
    static int pageFaults(int n, int c, int pages[]){
        Deque<Integer> q = new ArrayDeque<>();
        int pageFault = 0 ;
        
        for(int i = 0 ; i<n ; i++){
            int curr = pages[i] ; 
            
            if(!q.contains(curr)){
                q.offerLast(curr); 
                pageFault ++ ; 
                
                if(q.size() > c){
                    q.pollFirst() ; 
                }
            }
            else{
                q.remove(curr); 
                q.offerLast(curr); 
            }
        }
        return pageFault; 
    }
}