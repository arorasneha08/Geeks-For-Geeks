import java.util.*;

class Solution {

    static ArrayList<Integer> sortBySetBitCount(int arr[]) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        // convert int[] → ArrayList
        for (int num : arr) {
            list.add(num);
        }

        // stable sort based on set bits (descending)
        Collections.sort(list, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);

            return countB - countA;
        });

        return list;
    }
}