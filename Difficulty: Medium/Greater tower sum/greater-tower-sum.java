// User function Template for Java

class Solution {
    // Function for finding maximum and value pair
    public static int SaveGotham(int arr[]) {
        int n = arr.length ; 
        Stack<Integer> st = new Stack<>();
        int res[] = new int[n]; 
        
        for(int i = n-1 ; i >= 0 ; i --){
            while(!st.isEmpty() && arr[i] >= st.peek()){
                st.pop(); 
            }
            res[i] = (st.isEmpty()) ? 0 : st.peek(); 
            st.push(arr[i]); 
        }
        int mod = (int)1e9+7 ; 
        long sum = 0 ; 
        for(int num : res){
            sum = (sum + num) % mod ; 
        }
        return (int)sum ; 
    }
}
