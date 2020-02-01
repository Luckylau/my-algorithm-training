package l.series;

/**
 * @Author luckylau
 * @Date 2020/2/1
 */
public class Exist {
    private static final int[][] direction = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C'}, {'D', 'E', 'F'}};
        Exist exist = new Exist();
        System.out.println(exist.exist(board, "ABED"));
    }

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] isVisited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (exist(0, i, j, board, isVisited, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(int cur, int i, int j, char[][] board, boolean[][] isVisted, String word) {
        if (cur == word.length()) {
            return true;
        }
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j]
                != word.charAt(cur) || isVisted[i][j]) {
            return false;
        }
        isVisted[i][j] = true;
        for (int[] dir : direction) {
            if (exist(cur + 1, i + dir[0], j + dir[1], board, isVisted, word)) {
                return true;
            }
        }
        isVisted[i][j] = false;
        return false;
    }
}
