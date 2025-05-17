//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

import java.util.*;

class Solution {
    public ArrayList<String> findWords(char[][] board, String[] words) {
        Set<String> resultSet = new HashSet<>();
        int n = board.length;
        int m = board[0].length;

        // Preprocess board characters
        Set<Character> boardChars = new HashSet<>();
        for (char[] row : board) {
            for (char ch : row) {
                boardChars.add(ch);
            }
        }

        for (String word : words) {
            // Quick prune: if the board doesn't contain necessary letters, skip
            if (!canExistOnBoard(word, boardChars)) continue;

            boolean found = false;
            for (int i = 0; i < n && !found; i++) {
                for (int j = 0; j < m && !found; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        boolean[][] visited = new boolean[n][m];
                        if (backtrack(i, j, 0, word, board, visited)) {
                            resultSet.add(word); // avoid duplicates
                            found = true;
                        }
                    }
                }
            }
        }

        return new ArrayList<>(resultSet);
    }

    private boolean canExistOnBoard(String word, Set<Character> boardChars) {
        for (char c : word.toCharArray()) {
            if (!boardChars.contains(c)) return false;
        }
        return true;
    }

    private boolean backtrack(int row, int col, int index, String word,
                              char[][] board, boolean[][] visited) {
        if (index == word.length()) return true;

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
            visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            int newRow = row + dRow[d];
            int newCol = col + dCol[d];
            if (backtrack(newRow, newCol, index + 1, word, board, visited)) {
                visited[row][col] = false;
                return true;
            }
        }

        visited[row][col] = false;
        return false;
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            int m = Integer.parseInt(sc.nextLine());
            char board[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] row = sc.nextLine().split(" ");
                for (int j = 0; j < m; j++) {
                    board[i][j] = row[j].charAt(0);
                }
            }
            String words[] = sc.nextLine().split(" ");
            // br.readLine();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findWords(board, words);
            Collections.sort(ans);
            if (ans.size() == 0) {
                System.out.println("[]");
                System.out.println("~");
                continue;
            }
            for (String s : ans) {
                System.out.print(s + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends