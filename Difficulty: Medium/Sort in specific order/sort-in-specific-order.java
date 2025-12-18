class Solution {
    public void sortIt(int[] arr) {
        int n = arr.length ;
        List<Integer> odd = new ArrayList<>(); 
        List<Integer> even = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i ++){
            if(arr[i] % 2 == 0){
                even.add(arr[i]); 
            }
            else{
                odd.add(arr[i]); 
            }
        }
        Collections.sort(odd); 
        Collections.sort(even);
        int idx = 0 ; 
        for(int i = odd.size()-1 ; i >= 0 ; i--){
            arr[idx ++] = odd.get(i); 
        }
        for(int i = 0 ; i < even.size() ; i++){
            arr[idx ++] = even.get(i); 
        }
        
    }
}
