class Solution {
    class Pair{
        int color ;
        int radius; 
        Pair(int c, int r){
            color = c ; 
            radius = r ; 
        }
    }
    public int findLength(int[] color, int[] radius) {
        int n = color.length ; 
        int m = radius.length ;
        Stack<Pair> st = new Stack<>(); 
        for(int i = 0 ; i < n ; i++){
            Pair curr = new Pair(color[i] , radius[i]); 
            if(!st.isEmpty() && st.peek().color == curr.color && st.peek().radius == curr.radius){
                st.pop(); 
            }
            else{
                st.push(curr); 
            }
        }
        return st.size() ; 
    }
}