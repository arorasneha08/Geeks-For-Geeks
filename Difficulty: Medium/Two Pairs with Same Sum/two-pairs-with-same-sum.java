class Solution {
    public ArrayList<Integer> findPairs(int[] arr) {
        int n = arr.length ;
        HashMap<Integer, ArrayList<int[]>> mpp = new HashMap<>(); 
        
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                int sum = arr[i] + arr[j]; 
                mpp.putIfAbsent(sum, new ArrayList<>()); 
                mpp.get(sum).add(new int[]{i, j});
            }
        }
        
        for(int i = 0 ; i< n ; i++){
            for(int j = i + 1 ; j< n ; j++){
                int sum = arr[i] + arr[j];
                
                if(mpp.containsKey(sum)){
                    
                    for(int[] pair : mpp.get(sum)){
                        int x = pair[0];
                        int y = pair[1];
                        if(x != i && y != j && x != j && y != x && i < x){
                            return new ArrayList<>(Arrays.asList(i, j, x, y));
                        }
                    }
                }
            }
        }
        return new ArrayList<>(Arrays.asList(-1, -1 ,-1, -1));
    }
}