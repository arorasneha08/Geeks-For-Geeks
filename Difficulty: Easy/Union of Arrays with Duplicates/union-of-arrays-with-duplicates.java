class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b); 
       int n1 = a.length ; 
       int n2 = b.length ; 
       int i = 0 ;
       int j = 0 ; 
       ArrayList<Integer> ans = new ArrayList<>(); 
       while(i < n1 && j < n2){
           if(a[i] == b[j]){
               if(ans.isEmpty() || ans.get(ans.size()-1) != a[i]){
                   ans.add(a[i]); 
               }
               i++ ;
               j++;
           }
           else if(a[i] < b[j]){
               if(ans.isEmpty() || ans.get(ans.size()-1) != a[i]){
                   ans.add(a[i]);
               }
               i++ ;
           }
           else{
               if(ans.isEmpty() || ans.get(ans.size()-1) != b[j]){
                   ans.add(b[j]);
               }
               j++;
           }
       }
       while(i < n1){
           if(ans.isEmpty() || ans.get(ans.size()-1) != a[i]){
               ans.add(a[i]);
           }
           i++ ; 
       }
       while(j < n2){
           if(ans.isEmpty() || ans.get(ans.size()-1) != b[j]){
               ans.add(b[j]); 
           }
           j++ ; 
       }
       return ans;
    }
}