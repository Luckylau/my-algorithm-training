package o.series;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */

import java.util.ArrayList;

/**
 * @Author luckylau
 * @Date 2019/12/24
 */
public class FindContinuousSequence {
    //解答见：/Users/yrd/Documents/github/my-algorithm-training/src/c/series/FindSumIsN.java

    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        int low = 1;
        int high = 2;
        while (low < high) {
            int cur = (low + high) * (high - low + 1) / 2;
            if (cur == sum) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    tmp.add(i);
                }
                list.add(tmp);
                low++;
            } else if (cur > sum) {
                low++;
            } else {
                high++;
            }
        }
        return list;
    }


}
