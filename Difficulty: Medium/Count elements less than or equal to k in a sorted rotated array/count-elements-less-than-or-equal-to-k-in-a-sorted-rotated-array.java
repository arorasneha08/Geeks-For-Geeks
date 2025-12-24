class Solution {
    public int countLessEqual(int[] arr, int x) {
        int pivot = getPivot(arr);
        int leftSide = getLessEqual(arr, x, 0, pivot - 1);
        int rightSide = getLessEqual(arr,x , pivot, arr.length - 1);
        
        return leftSide + rightSide;
    }
    private int getLessEqual(int[] arr, int x, int l, int r){
        int origL = l;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] > x) {
                r = mid - 1;
            } else l = mid + 1;
        }
        return l - origL;
    }
    private int getPivot(int[] arr) {
          int l = 0, r = arr.length - 1;
    
          while (l < r) {
              int mid = l + (r - l) / 2;
              if (arr[mid] > arr[r]) {
                  l = mid + 1;
              } else {
                  r = mid;
              }
          }
    
          return l; 
    }
}