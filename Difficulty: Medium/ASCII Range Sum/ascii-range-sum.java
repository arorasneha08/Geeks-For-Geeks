class Solution {
    public ArrayList<Integer> asciirange(String s) {
        ArrayList<Integer> res = new ArrayList<>(); 
        int n = s.length(); 
        int first[] = new int[26]; 
        int last[] = new int[26];
        Arrays.fill(first , -1) ;
        Arrays.fill(last , -1) ;
        for(int i = 0 ; i < n ; i++){
            int idx = s.charAt(i) - 'a'; 
            if(first[idx] == -1){
                first[idx] = i ; 
            }
            last[idx] = i ; 
        }
        for(int i = 0 ; i < 26 ; i++){
            if(first[i] != -1 && last[i] !=-1 && first[i] < last[i]){
                int sum = 0 ; 
                for(int j = first[i] + 1 ; j < last[i] ; j++){
                    sum += (int) s.charAt(j); 
                }
                if(sum > 0){
                    res.add(sum); 
                }
            }
        }
        return res; 
    }
}