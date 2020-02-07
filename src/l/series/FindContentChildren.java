package l.series;

import java.util.Arrays;

/**
 * @Author luckylau
 * @Date 2020/1/7
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return -1;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;
        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) {
                child++;
            }
            cookie++;
        }
        return child;
    }
}
