class Solution {
    static int[] vis;
    static ArrayList<ArrayList<Integer>>ans;
    private static void search(int[] arr,ArrayList<Integer>ar,int n){
        if(ar.size()==n){
            ans.add(new ArrayList<Integer>(ar));
            return;
        }
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                ar.add(arr[i]);
                vis[i]=1;
                search(arr,ar,n);
                vis[i]=0;
                ar.remove(ar.size()-1);
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer>ar = new ArrayList<Integer>();
        int n = arr.length;
        vis = new int[n];
        search(arr,ar,n);
        return ans;
    }
};