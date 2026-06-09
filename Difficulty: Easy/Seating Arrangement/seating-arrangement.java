class Solution {
    public boolean canSeatAllPeople(int k, int[] seats) {
        // code here
        int n = seats.length;
        if(n == 1 && seats[0] == 0) return true;
        int i = 0;
        while(i < n && k > 0){
            if(seats[i] == 0){
                if(i == 0 && i + 1 < n && seats[i+1] == 0){
                    k--;
                    seats[i] = 1;
                }else if((i == n - 1) && (i - 1) >= 0 && seats[i-1] == 0){
                    k--;
                    seats[i] = 1;
                }else if(i > 0 && seats[i-1] == 0 && i < n-1 && seats[i+1] == 0){
                    k--;
                    seats[i] = 1;
                }
            }
            i++;
        }
        return k==0;
    }
}