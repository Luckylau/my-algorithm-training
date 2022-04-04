package n.series.dynamicprogramming;

/**
 * @Author luckylau
 * @Date 2022/3/31
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * You can only move either down or right at any point in time.
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] triangle = new int[4][4];
        triangle[0][0] = 2;
        triangle[1][0] = 3;
        triangle[2][0] = 6;
        triangle[3][0] = 4;
        triangle[1][1] = 4;
        triangle[2][1] = 5;
        triangle[3][1] = 1;
        triangle[2][2] = 7;
        triangle[3][2] = 8;
        triangle[3][3] = 3;
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(triangle));

    }

    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }
        return sum[m - 1][n - 1];
    }

}
