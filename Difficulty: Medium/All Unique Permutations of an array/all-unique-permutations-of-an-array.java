class Solution {
    private static void func(int arr[] , ArrayList<Integer> list , ArrayList<ArrayList<Integer>> res , int visited []){
        if(list.size() == arr.length){
            res.add(new ArrayList<>(list)); 
            return ;
        }
        for(int i = 0 ; i < arr.length ; i++){
            if(visited[i] == 1) continue; 
            
            if(i > 0 && arr[i] == arr[i-1] && visited[i-1] == 0) continue ; 
            visited[i] = 1 ; 
            list.add(arr[i]);
            
            func(arr , list , res, visited); 
            
            list.remove(list.size()-1); 
            visited[i] = 0 ; 
        }
    }
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>(); 
        Arrays.sort(arr); 
        int n = arr.length ; 
        int visited[] = new int[n]; 
        func(arr , list , res , visited); 
        return res; 
    }
};