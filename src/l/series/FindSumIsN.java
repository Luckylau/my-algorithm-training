package l.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入N，找出1到N中和为N的所有组合
 */
public class FindSumIsN {
    public static void main(String[] args) {
        FindSumIsN findSumIsN = new FindSumIsN();
        System.out.println(Arrays.deepToString(findSumIsN.findSumIsN(15).toArray()));

    }

    public List<List<Integer>> findSumIsN(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n < 3) {
            return res;
        }
        int low = 1;
        int high = 2;
        int sum = low + high;
        int mid = n / 2;
        while (low < mid) {
            if (sum == n) {
                List<Integer> list = new ArrayList<Integer>();
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                res.add(list);
            }
            while (sum > n) {
                sum -= low;
                low++;
                if (sum == n) {
                    List<Integer> list = new ArrayList<Integer>();
                    for (int i = low; i <= high; i++) {
                        list.add(i);
                    }
                    res.add(list);
                }
            }
            high++;
            sum += high;
        }
        return res;
    }

}
