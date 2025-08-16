class Solution {
    public String findLargest(int[] arr) {
        int n = arr.length ; 
        StringBuilder str = new StringBuilder(); 
        String[] s = new String[n]; 
        for(int i = 0 ; i < n ; i++){
            s[i] = arr[i] + ""; 
        }
        Arrays.sort(s , (a,b) -> (b + a).compareTo(a + b)); 
        if(s[0].equals("0")){
            return "0" ; 
        }
        for(int i = 0 ; i < n ; i++){
            str.append(s[i]); 
        }
        return str.toString(); 
    }
}