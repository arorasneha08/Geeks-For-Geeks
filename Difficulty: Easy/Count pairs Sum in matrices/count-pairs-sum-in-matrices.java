class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        HashMap<Integer , Integer> mpp = new HashMap<>(); 
        for(int i = 0 ; i < mat1.length ; i++){
            for(int j = 0 ; j < mat1[0].length ;j++){
                mpp.put(mat1[i][j] , mpp.getOrDefault(mat1[i][j], 0)+1); 
            }
        }
        int count = 0 ; 
        for(int i = 0 ; i< mat2.length ; i++){
            for(int j = 0 ; j < mat2[0].length ; j++){
                int rem = x - mat2[i][j];
                if(mpp.containsKey(rem)){
                    count ++;
                }
            }
        }
        return count ; 
    }
}