


class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length ; 
        ArrayList<Integer> ans = new ArrayList<>(); 
        Stack<Integer> st = new Stack<>() ;
        for(int i = 0 ;i<n ;i++){
            while(!st.isEmpty() && arr[i] >= arr[st.peek()]){
                st.pop() ;
            }
            int span = st.isEmpty() ? i+1 : i - st.peek() ; 
            ans.add(span) ;
            st.push(i); 
        }
        return ans ; 
    }
}