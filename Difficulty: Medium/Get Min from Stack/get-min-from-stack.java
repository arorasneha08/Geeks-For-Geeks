//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		
System.out.println("~");
}
		
	}
}



// } Driver Code Ends


class GfG {
    int minElem; // Stores the current minimum element
    Stack<Integer> st; // Main stack

    GfG() {
        minElem = 0;
        st = new Stack<>();
    }

    // Get the minimum element in the stack
    int getMin() {
        if (st.isEmpty()) return -1; // Return -1 if the stack is empty
        return minElem;
    }

    // Pop an element from the stack
    int pop() {
        if (st.isEmpty()) return -1; // Return -1 if the stack is empty
        int top = st.pop();

        // If the popped element is less than minElem, it means minElem was stored in encoded form
        if (top < minElem) {
            int originalMin = minElem; // Retrieve the original minimum
            minElem = 2 * minElem - top; // Update minElem to the previous minimum
            return originalMin;
        }
        return top; // Otherwise, return the normal top value
    }

    // Push an element into the stack
    void push(int x) {
        if (st.isEmpty()) {
            st.push(x);
            minElem = x; // Initialize minElem for the first element
        } else if (x < minElem) {
            st.push(2 * x - minElem); // Encode the new minimum element
            minElem = x; // Update minElem
        } else {
            st.push(x); // Push normally if x is greater than or equal to minElem
        }
    }
}


