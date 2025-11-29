// User function Template for Java

class Solution {
    private boolean dfs(int appl , int match[] , int mat[][] , int visited[] , int jobs , int applicants){
        
        for(int job = 0 ; job < jobs ; job++){
            if(visited[job] == 0 && mat[appl][job] == 1){
                visited[job] = 1; 
                
                if(match[job] < 0 || dfs(match[job] , match , mat, visited , jobs , applicants)){
                    match[job] = appl ; 
                    return true ; 
                }
            }
        }
        return false; 
    }
    public int maximumMatch(int[][] mat) {
        int applicants = mat.length ;
        int jobs = mat[0].length; 
        int match[] = new int[jobs]; 
        Arrays.fill(match , -1);
        
        int res = 0 ;
        
        for(int appl = 0 ; appl < applicants ; appl++){
            int visited[] = new int[jobs];
            if(dfs(appl , match , mat , visited ,jobs , applicants)){
                res ++; 
            }
        }
        return res; 
    }
}