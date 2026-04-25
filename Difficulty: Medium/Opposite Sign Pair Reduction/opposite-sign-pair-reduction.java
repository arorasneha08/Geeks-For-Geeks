class Solution {
     public ArrayList<Integer> reducePairs(int[] arr) {

        ArrayList<Integer>ans=new ArrayList<>();

        for(int e:arr){

         while(!ans.isEmpty()&&ans.get(ans.size()-1)*e<0){

             int top=ans.get(ans.size()-1);

             if(Math.abs(top)>Math.abs(e)){

                 e=top;

                 ans.remove(ans.size()-1);

             }else if(Math.abs(top)<Math.abs(e)){

                 ans.remove(ans.size()-1);

             }else{

                 ans.remove(ans.size()-1);

                 e=0;

                 break;

             }

         }

         if(e!=0)

         ans.add(e);

        }

       return ans;

    }
}