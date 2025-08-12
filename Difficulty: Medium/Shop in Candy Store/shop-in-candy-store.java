class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        Arrays.sort(prices); 
        int n = prices.length ; 
        int left = 0 ; 
        int right = n-1;
        int min = 0 ;
        int max = 0 ;
        while(n > 0){
            min += prices[left];
            max += prices[right]; 
            left ++;
            right --; 
            n--; 
            n-= k ; 
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(min);
        list.add(max); 
        return list ; 
    }
}
