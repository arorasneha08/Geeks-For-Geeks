class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefix = new int[n];
        
        prefix[0] = arr[0];
        
        for(int i = 1; i < n; i++){
            prefix[i] = arr[i] + prefix[i-1];
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int[] q:queries){
            int st = q[0];
            int end = q[1];
            
            int sum;
            if(st != 0){
                sum = prefix[end] - prefix[st-1];
            }else{
                sum = prefix[end];
            }
            
            res.add(sum / (end-st+1));
        }
        
        return res;
    }
}