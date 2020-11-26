import java.util.Arrays;

public class $12 {
    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        if (board == null || word == null) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        int pathLen = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (exitsHelper(board, word, i, j, pathLen, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean exitsHelper(char[][] board, String word, int row, int col,
                               int pathLen, boolean[][] visited) {
        if (pathLen == word.length()) {
            return true;
        }

        int rows = board.length;
        int cols = board[0].length;
        boolean hasPath = false;

        if (row < rows && row >= 0 && col < cols && col >= 0
             && board[row][col] == word.charAt(pathLen)
             && !visited[row][col]) {
            pathLen++;
            visited[row][col] = true;

            hasPath = exitsHelper(board, word, row, col-1, pathLen, visited)
                    || exitsHelper(board, word, row-1, col, pathLen, visited)
                    || exitsHelper(board, word, row, col+1, pathLen, visited)
                    || exitsHelper(board, word, row+1, col, pathLen, visited);

            if (!hasPath) {
                pathLen--;
                visited[row][col] = false;
            }
        }

        return hasPath;
    }

    public static void main(String[] args) {
        char[][] board = {{'a','b','c','e'},
                {'s','f','c','s'},
                {'a','d','e','e'}};

        String word = "bcce";
        String word2 = "abcb";

        System.out.println(exist(board, word));
        System.out.println(exist(board, word2));
    }
}
