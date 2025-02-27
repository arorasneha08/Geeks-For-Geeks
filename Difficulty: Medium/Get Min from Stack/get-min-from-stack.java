//{ Driver Code Starts
import java.util.*;

class Get_Min_From_Stack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int q = sc.nextInt(); // Number of queries
            Solution g = new Solution();

            while (q-- > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    g.pop(); // Just call pop(), do not print anything
                } else if (qt == 3) {
                    System.out.print(g.peek() + " "); // Print top element
                } else if (qt == 4) {
                    System.out.print(g.getMin() + " "); // Print minimum element
                }
            }
            System.out.println("\n~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    Stack<Integer> st = new Stack<>(); 
    int minElem;  

    public Solution() {
        minElem = -1; // Default value for an empty stack
    }

    // Add an element to the top of Stack
    public void push(int x) {
        if (st.isEmpty()) {
            st.push(x);
            minElem = x;
        } else if (x < minElem) {
            st.push(2 * x - minElem); // Store the encoded value
            minElem = x;  
        } else {
            st.push(x);
        }
    }

    // Remove the top element from the Stack
    public void pop() {
        if (st.isEmpty()) return; 

        int top = st.pop();
        if (top < minElem) { // If top is an encoded value
            minElem = 2 * minElem - top; 
        }

        // If stack becomes empty after popping, reset minElem
        if (st.isEmpty()) {
            minElem = -1;
        }
    }

    // Returns top element of the Stack
    public int peek() {
        if (st.isEmpty()) return -1; // Return -1 for empty stack

        int top = st.peek();
        return (top < minElem) ? minElem : top;
    }

    // Finds minimum element of Stack
    public int getMin() {
        return (st.isEmpty()) ? -1 : minElem;
    }
}