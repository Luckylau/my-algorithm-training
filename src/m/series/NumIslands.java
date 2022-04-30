package m.series;

/**
 * 200. 岛屿数量
 *
 * @Author luckylau
 * @Date 2022/4/30
 */
public class NumIslands {
    private int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }

            }
        }

        return count;


    }

    private void dfs(char[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int[] dir : direction) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}
