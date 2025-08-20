class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length ; 
        int m = mat[0].length ; 
        int size = n * m  ;
        int low = 0 ;
        int high = size - 1 ; 
        while(low <= high){
            int mid = (low + high)/2 ; 
            int elem = mat[mid / m][mid % m]; 
            int start = mat[low / m][low % m]; 
            int end = mat[high / m][high % m]; 
            if(elem == x) return true;  
            
            else if(elem > end){
                if(start <= x && elem > x){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(end >= x && x > elem){
                    low = mid + 1;
                }
                else{
                    high = mid - 1 ; 
                }
            }
        }
        return false; 
    }
}