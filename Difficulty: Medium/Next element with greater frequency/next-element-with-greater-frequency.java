class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        int n = arr.length ; 
        ArrayList<Integer> res = new ArrayList<>();
        int ans[] = new int[n]; 
        Arrays.fill(ans , -1); 
        HashMap<Integer , Integer> mpp = new HashMap<>(); 
        for(int i = 0 ; i < n ; i ++){
            mpp.put(arr[i] , mpp.getOrDefault(arr[i] , 0) + 1) ;
        }
        Stack<Integer> st = new Stack<>(); 
        for(int i = n-1; i >= 0 ; i--){
            while(!st.isEmpty() && mpp.get(arr[i]) >= mpp.get(st.peek())){
                st.pop(); 
            }   
            if(!st.isEmpty()){
                ans[i] = st.peek(); 
            }
            st.push(arr[i]); 
        }
        for(int i = 0 ; i< n ; i++){
            res.add(ans[i]); 
        }
        return res; 
    }
}