package l.series;

/**
 * @Author luckylau
 * @Date 2020/1/19
 */
public class FindCircleNum {
    public static void main(String[] args) {
        int[][] M = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        FindCircleNum findCircleNum = new FindCircleNum();
        System.out.println(findCircleNum.findCircleNum(M));
    }

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        int num = 0;
        int n = M.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                num++;
            }
        }
        return num;


    }

    private void dfs(int[][] M, int i, boolean[] visited) {
        visited[i] = true;
        for (int k = 0; k < M.length; k++) {
            if (M[i][k] == 1 && !visited[k]) {
                dfs(M, k, visited);
            }
        }
    }
}
