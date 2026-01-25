class Solution {
    int findWays(int n) {
        ArrayList<String> list = new ArrayList<>(); 
        String s = "";  
        if(n % 2 != 0) return 0 ; 
        helper(n / 2 , n/2 , list , s); 
        return list.size(); 
    }
    void helper(int open , int close , ArrayList<String> list , String str){
        if(open == 0 && close == 0){
            if(!list.contains(str)) list.add(str); 
        }
        if(open > 0){
            helper(open - 1 , close , list , str + "("); 
        }
        if(close > open){
            helper(open , close - 1 , list , str + ")"); 
        }
    }
}
