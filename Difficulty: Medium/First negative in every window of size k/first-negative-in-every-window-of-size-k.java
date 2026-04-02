class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        int n = arr.length; 
        List<Integer> res = new ArrayList<>(); 
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < k ; i++){
            if(arr[i] < 0){
                q.offer(i); 
            }
        }
        if(q.isEmpty()) res.add(0); 
        else res.add(arr[q.peek()]); 
        
        for(int i = k ; i < n ; i++){
            while(!q.isEmpty() && q.peek() <= i - k){
                q.poll(); 
            }
            if(arr[i] < 0) q.offer(i); 
            if(q.isEmpty()) res.add(0);
            else res.add(arr[q.peek()]); 
        }
        return res; 
    }
}