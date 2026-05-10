class Solution {
    public int maxProfit(int x, int y, int[] a, int[] b) {
        // code here
        int n = a.length;
        
        int[] c = new int[n];
        int[] d = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            c[i] = a[i] - b[i];
            d[i] = b[i] - a[i];
        }
        // 0 --> diff , 1 --> idx , 2 --> x/y
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((temp1 , temp2) ->{
            return Integer.compare(temp2[0] , temp1[0]);
        });

        for(int i = 0 ; i < n ; i++){
            pq.add(new int[]{c[i] , i , 0});
            pq.add(new int[]{d[i] , i , 1});
            
        }
        
        boolean[] taken = new boolean[n];
        int maxProfit = 0;

        while(n > 0){
            int[] temp = pq.remove();
            int idx = temp[1];
            int arr_no = temp[2];
            
            if(!taken[idx]){
                if(arr_no == 0 && x > 0){
                    maxProfit += a[idx];
                    x--;
                    taken[idx] = true;
                    n--;
                }else if(arr_no == 1 && y > 0){
                    maxProfit += b[idx];
                    y--;
                    taken[idx] = true;
                    n--;
                }
            
            }
        }
        
        return maxProfit;
    }
}