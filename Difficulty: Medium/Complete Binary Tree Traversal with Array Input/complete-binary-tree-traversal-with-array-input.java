class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(); 
        int n = arr.length ; 
        int idx = 0 ; 
        int level = 1 ; 
        
        while(idx < n){
            ArrayList<Integer> list = new ArrayList<>(); 
            for(int i = 0 ; i < level && idx < n ; i++){
                list.add(arr[idx++]); 
            }
            Collections.sort(list); 
            res.add(list); 
            level *= 2 ; 
        }
        return res; 
    }
}