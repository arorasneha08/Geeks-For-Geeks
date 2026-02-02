class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        ArrayList<Integer> res = new ArrayList<>(); 
        int n = mat.length ; 
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0] , b[0])); 
        
        for(int i = 0 ; i < n ; i++){
            pq.offer(new int[]{mat[i][0] , i , 0}); 
        }
        while(!pq.isEmpty()){
            int poll[] = pq.poll(); 
            int val = poll[0]; 
            int i = poll[1];
            int j = poll[2]; 
            res.add(val); 
            
            if(j + 1 < mat[i].length){
                pq.offer(new int[]{mat[i][j+1] , i , j+1}); 
            }
        }
        return res; 
    }
}