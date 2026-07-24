class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        ArrayList<ArrayList<String>> res = new ArrayList<>(); 
        int n = arr.length ; 
        HashMap<String , ArrayList<String>> mpp = new HashMap<>(); 
        
        for(int i = 0 ; i < n ; i++){
            String word = arr[i]; 
            char ch[] = word.toCharArray(); 
            Arrays.sort(ch); 
            String newWord = new String(ch); 
            if(!mpp.containsKey(newWord)){
                mpp.put(newWord , new ArrayList<>()); 
            }
            mpp.get(newWord).add(word); 
        }
        for(ArrayList<String> list : mpp.values()){
            res.add(list); 
        }
        return res; 
    }
}