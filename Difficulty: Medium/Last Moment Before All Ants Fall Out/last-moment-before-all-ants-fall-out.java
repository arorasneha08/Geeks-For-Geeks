class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        int n1=left.length;
        int n2=right.length;
        
        int lMax=0,rMax=Integer.MAX_VALUE;
        if(n1>0) {
           for(int num:left) {
               lMax=Math.max(num,lMax);
           }   
        }
        if(n>0) {
            for(int num:right) {
                rMax=Math.min(num,rMax);
            }
        }
        return Math.max(lMax,n-rMax);
    }
}