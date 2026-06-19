class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        // code here
        int sum_up_to_i = 0;
        int sum_up_to_half_i = 0;
        
        int n = arr.length;
        int j = 0;
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            if(i % 2 == 0 && i / 2 >= 0){
                sum_up_to_half_i += arr[i/2];
                j = i / 2;
            }
            sum_up_to_i += arr[i];
            
            int midEle = arr[i/2];
            
            int rightWindowSize = (i - j);
            int leftWindowSize = j + 1;
            
            int rightWindowSum = sum_up_to_i - sum_up_to_half_i;
            int leftWindowSum = sum_up_to_half_i;
            
            int rightWindowCost = Math.abs(rightWindowSum - midEle * rightWindowSize);
            int leftWindowcost = Math.abs(midEle * leftWindowSize - leftWindowSum);
            
            int totalOperationCost = rightWindowCost + leftWindowcost;
            
            result.add(totalOperationCost);
            
        }
        return result;
    }
}