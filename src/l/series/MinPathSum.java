package l.series;

/**
 * @Author luckylau
 * @Date 2020/2/8
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {3, 5, 8}};
        MinPathSum minPathSum = new MinPathSum();
        System.out.println(minPathSum.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i != m - 1 && j == n - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (i == m - 1 && j != n - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (i != m - 1 && j != n - 1) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }
}
