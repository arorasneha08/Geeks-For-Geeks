class Solution {
    public int minDifference(String[] arr) {
        int n = arr.length ; 
        int times[] = new int[n] ;
        for(int i = 0 ; i < n ; i++){
            String a[] = arr[i].split(":"); 
            int hrs = Integer.parseInt(a[0]); 
            int mins = Integer.parseInt(a[1]); 
            int secs = Integer.parseInt(a[2]); 
            int totalTime = hrs * 3600 + mins * 60 + secs; 
            times[i] = totalTime; 
        }
        Arrays.sort(times); 
        int minDiff = Integer.MAX_VALUE ; 
        for(int i = 0 ; i < n-1 ; i++){
            int diff = times[i+1] - times[i]; 
            minDiff = Math.min(diff , minDiff); 
        }
        int lastToFirst = 86400 - times[n-1] + times[0]; 
        minDiff = Math.min(minDiff , lastToFirst); 
        return minDiff; 
    }
}
