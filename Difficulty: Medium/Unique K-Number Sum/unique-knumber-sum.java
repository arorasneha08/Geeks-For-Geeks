class Solution {
    private void func(int idx , int sum , ArrayList<ArrayList<Integer>> res , ArrayList<Integer> list , int visited[], int target , int n){
        if(list.size() == n){
            if(sum == target) {
                res.add(new ArrayList<>(list)); 
            }
            return ; 
        }
        
        for(int i = idx ; i <= 9 ; i++){
            if(visited[i] == 1) continue ;
            if(sum + i > target) continue; 
            visited[i] = 1  ;
            list.add(i); 
            func(i + 1 , sum + i , res ,list , visited, target , n); 
            list.remove(list.size()-1);
            visited[i] = 0 ; 
        }
    }
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>() ; 
        ArrayList<Integer> list = new ArrayList<>() ;
        int visited[] = new int[10]; 
        func(1 , 0 , res , list, visited , n , k);
        return res ; 
    }
}