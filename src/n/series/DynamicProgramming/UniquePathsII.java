/**
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * Example
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 */
package n.series.DynamicProgramming;

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[4][5];
        obstacleGrid[1][1] = 1;
        UniquePathsII uniquePathsII = new UniquePathsII();
        System.out.println(uniquePathsII.uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid.length == 0 || obstacleGrid == null || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] path = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                path[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != 1) {
                path[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                } else {
                    path[i][j] = 0;
                }
            }
        }
        return path[m - 1][n - 1];
    }

}
