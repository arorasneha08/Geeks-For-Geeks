//{ Driver Code Starts
import java.util.*;


class StackUsingQueues
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			Queues g = new Queues();
			
			int q = sc.nextInt();
			while(q>0)
			{
				int QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					g.push(a);
				}
				else if(QueryType == 2)
				System.out.print(g.pop()+" ");
			q--;
			}	
			System.out.println();
				
			
			
		t--;
		
System.out.println("~");
}
	}
}


// } Driver Code Ends



class Queues {
    
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    void push(int a){
        q2.offer(a);
        while(!q1.isEmpty()){
            q2.offer(q1.poll()); 
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    int pop(){
        if(q1.isEmpty()) return -1 ;
        int val = q1.poll(); 
        return val ;
    }
}

