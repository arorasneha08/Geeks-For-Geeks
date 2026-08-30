class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        ArrayList<Integer> res = new ArrayList<>(); 
        int n = rank.length;
        int m = l.length; 
        int mark = 1 ; 
        HashMap<Integer , Integer> mpp = new HashMap<>(); 
        
        for(int i = 0 ; i < m ; i++){
            for(int j = l[i] ; j <= r[i] ; j++){
                mpp.put(mark , j); 
                mark ++; 
            }
        }
        for(int i = 0 ; i < n ; i++){
            res.add(mpp.get(rank[i]));
        }
        return res; 
    }
}