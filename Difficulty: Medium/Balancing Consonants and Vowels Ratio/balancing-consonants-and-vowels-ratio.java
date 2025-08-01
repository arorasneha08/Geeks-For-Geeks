class Solution {
    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'; 
    }
    public int countBalanced(String[] arr) {
        int n = arr.length ; 
        int balance[] = new int[n]; 
        for(int i = 0 ; i < n ; i++){
            int vow = 0 , cons = 0 ; 
            for(char ch : arr[i].toCharArray()){
                if(isVowel(ch)){
                    vow ++; 
                }
                else{
                    cons ++ ; 
                }
            }
            balance[i] = vow - cons; 
        }
        Map<Integer , Integer> mpp = new HashMap<>(); 
        mpp.put(0 , 1); 
        int res = 0 , sum = 0 ; 
        for(int i = 0 ; i < n ; i++){
            sum += balance[i] ; 
            res += mpp.getOrDefault(sum , 0);
            mpp.put(sum , mpp.getOrDefault(sum , 0) + 1); 
        }
        return res ; 
    }
}