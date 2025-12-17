class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        int n = arr.length ; 
        ArrayList<int[]> ans = new ArrayList<>(); 
        Arrays.sort(arr , (a,b) -> Integer.compare(a[0] , b[0])); 
        
        for(int i = 0 ; i<n ; i++){
            if(ans.isEmpty() || arr[i][0] > ans.get(ans.size()-1)[1]) {
                ans.add(arr[i]); 
            }
            else if(arr[i][1]> ans.get(ans.size()-1)[0]){
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1] , arr[i][1]); 
            }
        }
        return ans ; 
    }
}