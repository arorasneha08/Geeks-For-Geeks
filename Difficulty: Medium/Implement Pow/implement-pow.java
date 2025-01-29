//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    double pow(double a , int b){
        if(b == 0){
            return 1  ; 
        }
        double smallAns = pow(a, b/2) ;
        if(b % 2 == 0){
            return smallAns * smallAns ; 
        }
        return smallAns * smallAns * a ; 
    }
    double power(double b, int e) {
        if(b == 0) return 0 ;
        if(e < 0){
            return 1/pow(b,-e) ; 
        }
        return pow(b,e); 
    }
}

//{ Driver Code Starts.
// } Driver Code Ends