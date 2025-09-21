

/*Complete the function given below*/
class Solution {
    static int largestRectangleHist(int arr[], int n){
        Stack<Integer> st = new Stack<>();
        int area = 0 ; 
        for(int i = 0 ; i<n ; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                int h = arr[st.pop()]; 
                int w = st.empty() ? i : i - st.peek()-1 ; 
                area = Math.max(area , h * w) ; 
            }
            st.push(i); 
        }
        while(!st.isEmpty()){
            int h = arr[st.pop()] ; 
            int w = st.empty() ? n : n-st.peek()-1 ; 
            area = Math.max(area , h*w ); 
        }
        return area ; 
    }
    static int maxArea(int mat[][]) {
        int n = mat.length ;
        int m = mat[0].length ; 
        int prefSum[][] = new int[n][m];
        for(int j = 0 ; j< m ; j++){
            for(int i = 0 ; i<n ; i++){
                if(mat[i][j] == 0){
                    prefSum[i][j] = 0 ; 
                }
                else{
                    prefSum[i][j] = (i == 0) ?  1 : prefSum[i-1][j] + 1 ; 
                }
            }
        }
        int maxArea = 0 ;
        for(int i = 0 ; i<n ; i++){
            maxArea = Math.max(maxArea , largestRectangleHist(prefSum[i] , m)); 
        }
        return maxArea ; 
    }
}
