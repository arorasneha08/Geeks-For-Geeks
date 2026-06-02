class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int val=-1;
        int sum=0;
        for(int i=arr.length-1;i>=0;i--){
            if(val==-1){
                val=arr[i];
            }else if(val-arr[i]<k){
                sum+=(val+arr[i]);
                val=-1;
            }
            else{
                val=arr[i];
            }
        }return sum;
    }
}