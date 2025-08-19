class Solution {
    public ArrayList<Integer> farMin(int[] arr) {
        int n = arr.length; 
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1)); 
        
        List<int[]> list = new ArrayList<>(); 
        for (int i = 0; i < n; i++) {
            list.add(new int[]{arr[i], i}); 
        }
        
        list.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        int maxi = list.get(0)[1]; 
        for (int i = 1; i < n; i++) {
            if (maxi > list.get(i)[1]) {
                res.set(list.get(i)[1], maxi); 
            }
            maxi = Math.max(maxi, list.get(i)[1]); 
        }
        
        return res; 
    }
}
