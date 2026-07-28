class Solution {
    public List<List<Integer>> distinctPairs(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>(); 
        int n = arr.length ; 
        Arrays.sort(arr); 
        int left = 0 ; 
        int right = n-1; 
        while(left < right){
            int sum = arr[left] + arr[right]; 
            if(sum == target){
                res.add(Arrays.asList(arr[left], arr[right])); 
                
                int l = arr[left]; 
                int r = arr[right];
                while(left < right && arr[left] == l) left ++; 
                while(left < right && arr[right] == r) right -- ; 
            }
            else if(sum < target){
                left ++; 
            }
            else{
                right -- ; 
            }
        }
        return res; 
    }
}