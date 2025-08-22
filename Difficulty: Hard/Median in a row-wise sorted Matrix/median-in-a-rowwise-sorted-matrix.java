

// User function Template for Java

class Solution {
    int findSmallerElements(int matrix[][], int assumedMedian) {
        int noOfSmallerElements = 0;
        for (int i = 0; i < matrix.length; i++) {
            int start = 0;
            int end = matrix[0].length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (matrix[i][mid] <= assumedMedian) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            noOfSmallerElements += start; 
        }
        return noOfSmallerElements;
    }

    int median(int mat[][]) {
        int r = mat.length;
        int c = mat[0].length;
        int n = r * c;
        int medianIndex = n / 2;

        int start = Integer.MAX_VALUE; 
        int end = Integer.MIN_VALUE;

        for (int i = 0; i < r; i++) {
            start = Math.min(start, mat[i][0]);  
            end = Math.max(end, mat[i][c - 1]); 
        }

        while (start <= end) {
            int assumedMedian = start + (end - start) / 2;
            int lesserElem = findSmallerElements(mat, assumedMedian);

            if (lesserElem <= medianIndex) {
                start = assumedMedian + 1;
            } else {
                end = assumedMedian - 1;
            }
        }

        return start;
    }

}