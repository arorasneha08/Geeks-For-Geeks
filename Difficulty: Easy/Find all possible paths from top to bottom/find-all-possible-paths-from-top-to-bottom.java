class Solution {
    private static void func(int i , int j , int mat[][] , ArrayList<Integer> list , ArrayList<ArrayList<Integer>> res , int n , int m){
        if(i < 0 || j < 0 || i >= n || j >= m ) return ; 
        list.add(mat[i][j]); 
        if(i == n-1 && j == m-1){
            res.add(new ArrayList<>(list)); 
            list.remove(list.size()-1);
            return ; 
        }
        
        func(i+ 1 , j , mat , list , res , n , m); 
        func(i , j+1 , mat , list , res , n , m) ;
        list.remove(list.size()-1); 
    }
    public static ArrayList<ArrayList<Integer>> findAllPossiblePaths(int n, int m, int[][] grid) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(); 
        ArrayList<Integer> list = new ArrayList<>(); 
        func(0 , 0 , grid , list , res , n , m);
        return res; 
    }
}
