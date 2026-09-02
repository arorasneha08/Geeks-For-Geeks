class Solution {
    public int solve(int n, String s) {
        int m = s.length(); 
        HashMap<Character,Integer> map = new HashMap<>();
        HashSet<Character> rejectedCan = new HashSet<>();

        for(int i = 0 ; i < s.length() ; i++){
            char cand = s.charAt(i);

            if(!rejectedCan.contains(cand)){
                if(map.containsKey(cand) || map.size() < n){
                    map.put(cand , map.getOrDefault(cand , 0) + 1);
                    if(map.get(cand) == 2){
                        map.remove(cand);
                    }
                }else{
                    rejectedCan.add(cand);
                }
            }
        }
        return rejectedCan.size();
    }
}
