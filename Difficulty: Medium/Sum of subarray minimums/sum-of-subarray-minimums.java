class Solution {
    private int[] nse(int arr[]){
        int n = arr.length ; 
        int res[] = new int[n]; 
        Stack<Integer> st = new Stack<>(); 
        
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop(); 
            }
            
            res[i] = (st.isEmpty()) ? n : st.peek(); 
            st.push(i); 
        }
        return res; 
    }
    private int[] pse(int arr[]){
        int n = arr.length ; 
        int res[] = new int[n]; 
        Stack<Integer> st = new Stack<>(); 
        
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop(); 
            }
            res[i] = (st.isEmpty()) ? -1 : st.peek(); 
            st.push(i); 
        }
        return res; 
    }
    public int sumSubMins(int[] arr) {
        int n = arr.length ; 
        int nse[] = nse(arr); 
        int pse[] = pse(arr);
        int res = 0 ; 
        int mod = (int) 1e9+7; 
        
        for(int i = 0 ; i < n ; i++){
            int left = i - pse[i]; 
            int right = nse[i] - i ; 
            res = (res + left * right * arr[i]) % mod; 
        }
        return res; 
    }
}
