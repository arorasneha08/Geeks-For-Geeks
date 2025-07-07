class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length; 
        int ans[] = new int[n]; 
        ArrayList<Integer> res = new ArrayList<>(); 
        
        for(int i = 0 ; i < n ; i++){
            ans[i] = -1; 
        }
        
        for(int i = 2 * n - 1 ; i >= 0 ; i--){
            while(!st.isEmpty() && st.peek() <= arr[i % n]){
                st.pop(); 
            }
            if(!st.isEmpty()){
                ans[i% n] = st.peek(); 
            }
            st.push(arr[i % n]); 
        }
        for(int i = 0 ; i < n ; i++){
            res.add(ans[i]);
        }
        return res ; 
    }
}