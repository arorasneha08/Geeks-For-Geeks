class Solution {
    class Pair{
        int value;
        int diff;
    
        Pair(int value,int diff){
            this.value = value;
            this.diff = diff;
        }
    }
    public void rearrange(int[] arr, int x) {
        List<Pair> list = new ArrayList<>();
        for(int i : arr){
            list.add(new Pair(i,Math.abs(x-i)));
        }
        Collections.sort(
            list, 
            (p1,p2) -> Integer.compare(p1.diff,p2.diff)
        );
        
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = list.get(i).value;
        }
    }
}
