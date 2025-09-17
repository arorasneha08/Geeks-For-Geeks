class Solution {
    static String decodeString(String s) {
        int n = s.length(); 
        Stack<Integer> count = new Stack<>();
        Stack<String> str = new Stack<>();
        int num = 0 ; 
        String curr = "" ; 
        
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i); 
            if(Character.isDigit(ch)){
                num = num * 10 + ch - '0'; 
            }
            else if(ch == '['){
                count.push(num); 
                str.push(curr); 
                num = 0  ;
                curr = ""; 
            }
            else if(ch == ']'){
                int cnt = count.pop(); 
                String prev = str.pop(); 
                String newStr = "" ;
                for(int j = 0 ; j < cnt ; j++){
                    newStr += curr; 
                }
                curr = prev + newStr ; 
            }
            else{
                curr += ch ; 
            }
        }
        return curr;  
    }
}