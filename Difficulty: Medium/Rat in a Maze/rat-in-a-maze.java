class Solution {
    private void func(int i , int j , String str , ArrayList<String> list, int visited[][] ,int n, int mat[][]){
        if(i < 0 || j < 0 || i >=n || j >= n) return ;
        if(mat[i][j] == 0 || visited[i][j] == 1) return ; 
        
        if(i == n-1 && j == n-1){
            list.add(str); 
            return ; 
        }
        
        visited[i][j] = 1  ; 
        func(i - 1 , j , str + 'U' , list , visited , n, mat); 
        func(i , j-1 , str + 'L' , list , visited , n , mat); 
        func(i , j+1 , str + 'R' , list , visited , n , mat); 
        func(i + 1 , j , str + 'D', list , visited , n, mat); 
        visited[i][j] = 0 ;
        
        
    }
    public ArrayList<String> ratInMaze(int[][] mat) {
        int n = mat.length ;
        String str = ""; 
        int visited[][] = new int[n][n];
        ArrayList<String> list = new ArrayList<>(); 
        if(mat[0][0] == 0) return list; 
        func(0 , 0, str , list , visited, n , mat); 
        Collections.sort(list); 
        return list ;
    }
}