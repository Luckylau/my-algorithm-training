package l.series;

/**
 * @Author luckylau
 * @Date 2020/1/17
 */
public class MaxAreaOfIsland {
    private int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 0, 1}};
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int area = 1;
        for (int[] dir : direction) {
            int ci = dir[0] + i;
            int cj = dir[1] + j;
            area += dfs(grid, ci, cj);
        }
        return area;
    }
}
