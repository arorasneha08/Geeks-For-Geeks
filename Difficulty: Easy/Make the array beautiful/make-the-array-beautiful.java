class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        int n = arr.length ;
        Stack<Integer> st = new Stack<>(); 
        List<Integer> res = new ArrayList<>(); 
        for(int i = 0 ; i < n ; i++){
            if(st.isEmpty()) {
                st.push(arr[i]); 
            }
            else if((arr[i] >= 0 && st.peek() < 0) || (arr[i] < 0 && st.peek() >= 0)){
                st.pop(); 
            }
            else{
                st.push(arr[i]); 
            }
        }
        for(int num : st){
            res.add(num); 
        }
        return res; 
    }
}