/* BST Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/
class Solution {
    public static int pairsViolatingBST(Node root) {
        List<Integer> list = new ArrayList<>();
        createList(root,list);
        return mergeSort(list,0,list.size()-1);

    }
    public static void createList(Node root,List<Integer> list){
        if(root!=null){
            createList(root.left,list);
            list.add(root.data);
            createList(root.right,list);
        }
    }

    public static int merge(List<Integer> list,int low,int mid,int high){
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        int c = 0;

        while(left<=mid && right<=high){
            if(list.get(left)<=list.get(right)){
                temp.add(list.get(left));
                left++;
            }
            else{
                temp.add(list.get(right));
                c += mid-left+1;
                right++;
            }
        }

        while(left<=mid){
            temp.add(list.get(left));
                left++;
        }

        while(right<=high){
            temp.add(list.get(right));
                right++;
        }
        for(int i=low;i<=high;i++){
            list.set(i,temp.get(i-low));
        }
        return c;
    }

    public static int mergeSort(List<Integer> list,int low,int high){
        int c = 0;
        if(low>=high)
            return 0;
        int mid = low+(high-low)/2;
        c += mergeSort(list,low,mid);
        c += mergeSort(list,mid+1,high);
        c += merge(list,low,mid,high);
        return c;
    }
}