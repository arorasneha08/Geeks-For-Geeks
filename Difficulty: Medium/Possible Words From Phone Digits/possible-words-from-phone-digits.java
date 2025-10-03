class Solution {
    private void func(int idx , int arr[] , StringBuilder str , String keypad[], ArrayList<String> res){
        if(idx == arr.length){
            if(str.length() > 0){
                res.add(str.toString());
            }
            return ;
        }
        int digit = arr[idx]; 
        String currChoices = keypad[digit];
        if (currChoices.length() == 0) {
            func(idx + 1, arr, str, keypad, res);
            return;
        }
        for(int i = 0 ; i < currChoices.length() ; i++){
            str.append(currChoices.charAt(i)); 
            func(idx + 1 , arr , str , keypad , res); 
            str.deleteCharAt(str.length()-1);
        }
    }
    public ArrayList<String> possibleWords(int[] arr) {
        ArrayList<String> res = new ArrayList<>();
        int n = arr.length ;
        if(n == 0) return res; 
        String keypad[] = {"" , "" , "abc" , "def" , "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        func(0 , arr , new StringBuilder() , keypad , res); 
        return res; 
    }
}