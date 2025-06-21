class Solution {
    public ArrayList<Integer> findSubarray(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int sum = 0 , max = Integer.MIN_VALUE;
        int l = 0 , r= 0 , negIdx = -1;
        for(int i =0; i<arr.length; i++) {
            if(arr[i] < 0) {
                negIdx = i;
                sum = 0;
                continue;
            }
            sum+=arr[i];
            if(max <=sum) {
                max=sum;
                l=negIdx+1;
                r=i;
            }
        }
        for(int i= l; i<=r;i++) {
            if(arr[i] >= 0)
            ans.add(arr[i]);
        }
        if(ans.size()==0) { 
            ans.add(-1); return ans;
        };
        
        return ans;
    }
}
