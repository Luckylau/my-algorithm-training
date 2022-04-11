package m.series;

/**
 * 1143. 最长公共子序列
 *
 * @Author luckylau
 * @Date 2022/4/11
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        int row = text1.length();
        int column = text2.length();
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= column; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[row][column];
    }
}
