import java.util.*;

class Solution {
    private boolean func(int row, int col, int step, int arr[][], int n) {
        // Knight movement vectors
        int delRow[] = {2, 1, -1 , -2 , -2 , -1 , 1, 2}; 
        int delCol[] = {1 , 2, 2, 1, -1 , -2, -2, -1};

        // Base case: all squares visited
        if (step == n * n - 1) {
            return true;
        }

        // Try all 8 knight moves
        for (int i = 0; i < 8; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && arr[newRow][newCol] == -1) {
                arr[newRow][newCol] = step + 1;
                if (func(newRow, newCol, step + 1, arr, n)) {
                    return true;
                }
                arr[newRow][newCol] = -1; // backtrack
            }
        }
        return false;
    }

    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int arr[][] = new int[n][n];
        for (int[] row : arr) Arrays.fill(row, -1);

        // Start position
        arr[0][0] = 0;

        // Run the backtracking solver
        if (!func(0, 0, 0, arr, n)) {
            // No solution exists
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(-1);
            res.add(temp);
            return res;
        }

        // Copy solution into result
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                temp.add(arr[i][j]);
            }
            res.add(temp);
        }
        return res;
    }
}
