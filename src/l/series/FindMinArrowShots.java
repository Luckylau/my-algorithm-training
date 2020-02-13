package l.series;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author luckylau
 * @Date 2020/1/7
 */
public class FindMinArrowShots {

    public static void main(String[] args) {
        int[][] points = {{1, 2}, {2, 3}, {3, 4}};
        FindMinArrowShots findMinArrowShots = new FindMinArrowShots();
        System.out.println(findMinArrowShots.findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int cnt = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                end = points[i][1];
                cnt++;
            }
        }
        return cnt;
    }
}
