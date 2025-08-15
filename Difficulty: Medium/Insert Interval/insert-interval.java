

// User function Template for Java

class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        int n = intervals.length; 
        ArrayList<int[]> ans = new ArrayList<>();
        int i = 0 ; 
        
        while(i < n && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]); 
            i++;
        }
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0] , newInterval[0]); 
            newInterval[1] = Math.max(intervals[i][1] , newInterval[1]); 
            i++ ; 
        }
        ans.add(newInterval); 
        while(i < n){
            ans.add(intervals[i]); 
            i++ ; 
        }
        return ans  ; 
    }
}
