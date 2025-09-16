class Solution {
    private boolean isOperator(String s){
        return s.equals("+") || s.equals("-")|| s.equals("*") || s.equals("/") ||  s.equals("^");   
    }
    private int solve(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                return Math.floorDiv(a, b);
            case "^":
                return (int) Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
    public int evaluatePostfix(String[] arr) {
        int n = arr.length ; 
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ;  i< n ; i++){
            if(isOperator(arr[i])){
                int b = st.pop(); 
                int a = st.pop(); 
                st.push(solve(a , b, arr[i])); 
            }
            else{
                st.push(Integer.parseInt(arr[i])); 
            }
        }
        return st.pop();
    }
}