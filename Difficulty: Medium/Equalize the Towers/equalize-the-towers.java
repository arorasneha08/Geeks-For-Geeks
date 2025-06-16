class Solution {
    private int func(int targetHeight , int[] h , int[] c){
        int total = 0; 
        for(int i = 0 ;  i < h.length; i++){
            total += Math.abs(h[i] - targetHeight) * c[i]; 
        }
        return total ;
    }

    public int minCost(int[] heights, int[] cost) {
        int n = heights.length; 
        int start = Integer.MAX_VALUE; 
        int end = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
            start = Math.min(start , heights[i]); 
            end = Math.max(end , heights[i]); 
        }

        int res = Integer.MAX_VALUE; 

        while(start <= end){
            int mid = start + (end - start) / 2;

            int midCost = func(mid , heights, cost); 
            int leftCost = (mid > start) ? func(mid - 1 , heights, cost) : Integer.MAX_VALUE; 
            int rightCost = (mid < end) ? func(mid + 1 , heights, cost) : Integer.MAX_VALUE;

            res = Math.min(res , Math.min(leftCost , Math.min(midCost , rightCost))); 

            if(leftCost < midCost){
                end = mid - 1; 
            }
            else if(rightCost < midCost){
                start = mid + 1; 
            }
            else{
                break; 
            }
        }

        return res; 
    }
}
