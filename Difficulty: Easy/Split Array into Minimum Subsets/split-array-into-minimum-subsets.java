class Solution {
    int minSubsets(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);
        int cnt = 1;
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]>1) cnt++;   
        }
        return cnt;
    }
}