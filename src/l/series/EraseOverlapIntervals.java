package l.series;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author luckylau
 * @Date 2020/1/7
 */
public class EraseOverlapIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}};
        EraseOverlapIntervals eraseOverlapIntervals = new EraseOverlapIntervals();
        System.out.println(eraseOverlapIntervals.eraseOverlapIntervals(intervals));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                cnt++;
            }
        }
        return intervals.length - cnt;
    }
}
