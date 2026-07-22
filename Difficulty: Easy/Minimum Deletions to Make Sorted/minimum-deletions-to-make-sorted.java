class Solution {

    public int minDeletions(int[] arr) {

        if (arr == null || arr.length == 0) {

            return 0;

        }

        ArrayList<Integer> lis = new ArrayList<>();

        

        for (int num : arr) {

            int pos = binarySearch(lis, num);
            if (pos < 0) {

                pos = -(pos + 1);

            }

            if (pos < lis.size()) {

                lis.set(pos, num);

            } else {

                lis.add(num);

            }

        }
        return arr.length - lis.size();

    }

 

private int binarySearch(ArrayList<Integer>list,int num){

    int l=0,h=list.size();

    while(l<h){

        int mid=l+(h-l)/2;

        if(list.get(mid)<num)

        l=mid+1;

        else

        h=mid;

    }

    return l;

}

}