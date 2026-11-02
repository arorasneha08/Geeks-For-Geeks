class Solution {
    public int largestSumCycle(int edge[]){
        int n = edge.length;
        int[] counts = new int[n+1];
        int maxCount = -1, count = 0;
        for(int i = 0 ; i < n ; i++) {
            if(counts[i] == 0) {
                int j = i;
                int startCount = ++count;
                while(j != -1 && counts[j] == 0) {
                    counts[j] = count;
                    count += j;
                    j = edge[j];
                }
                if (j != -1 &&  counts[j] >= startCount) {
                    maxCount = Math.max(maxCount, count-counts[j]);
                }
            } 
        }
        return maxCount;
    }
}