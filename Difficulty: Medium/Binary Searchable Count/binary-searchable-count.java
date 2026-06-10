class Solution {
    private boolean bs(int s,int e,int[]arr,int x){

        if(s>e)return false;

        int m=s+(e-s)/2;

        if(arr[m]==x) return true;

        if(arr[m]<x)

        return bs(m+1,e,arr,x);

        return bs(s,m-1,arr,x);

    }
    public int binarySearchable(int[] arr) {
         int cnt=0,n=arr.length;

       for(int i=0;i<n;i++){

           if(bs(0,n-1,arr,arr[i]))

           cnt++;

       }

       return cnt;
    }
};