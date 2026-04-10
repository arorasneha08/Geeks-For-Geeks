class Solution {
    public ArrayList<Integer> find3Numbers(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>(); 
        int n = arr.length ; 
        int first = Integer.MAX_VALUE ;
        int sec = Integer.MAX_VALUE; 
        int candidate = Integer.MAX_VALUE ; 
        
        for(int i = 0; i < n ; i++){
            int num = arr[i]; 
            if(num <= candidate){
                candidate = num ; 
            }
            else if(num <= sec){
                first = candidate ; 
                sec = num ; 
            }
            else{
                res.add(first); 
                res.add(sec); 
                res.add(num); 
                return res; 
            }
        }
        return new ArrayList<>(); 
    }
}