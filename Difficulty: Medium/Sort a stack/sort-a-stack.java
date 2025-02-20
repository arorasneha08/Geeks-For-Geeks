//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    private void func(Stack<Integer> s, int element){
        if(s.isEmpty()|| s.peek() <= element){
            s.push(element);
            return ; 
        }
        int top = s.pop(); 
        
        func(s, element);
        
        s.push(top); 
    }
    public Stack<Integer> sort(Stack<Integer> s) {
        if(s.isEmpty()){
            return s ; 
        }
        int top = s.pop();
        
        sort(s);
        func(s, top); 
        
        return s ; 
    }
}