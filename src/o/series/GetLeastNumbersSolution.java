package o.series;
/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4
 */

import java.util.ArrayList;

/**
 * @Author luckylau
 * @Date 2019/12/29
 */
public class GetLeastNumbersSolution {
    //解答见；/Users/jasonlau/gitcode/my-algorithm-training/src/l/series/FindKMin.java

    public static void main(String[] args) {
        int[] nums = new int[]{13, 6, 8, 9, 2, 2};
        GetLeastNumbersSolution getLeastNumbersSolution = new GetLeastNumbersSolution();
        System.out.println(getLeastNumbersSolution.GetLeastNumbers_Solution(nums, 5));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0) {
            return list;
        }
        if (k > input.length) {
            return list;
        }
        int start = 0;
        int end = input.length - 1;
        int pivot = partion(input, start, end);
        while (pivot != k - 1 && start < end) {
            if (pivot > k - 1) {
                end = pivot - 1;
                pivot = partion(input, start, end);
            } else {
                start = pivot + 1;
                pivot = partion(input, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;

    }

    private int partion(int[] num, int start, int end) {
        int tmp = num[start];
        while (start < end) {
            while (start < end && num[end] >= tmp) {
                end--;
            }
            num[start] = num[end];
            while (start < end && num[start] <= tmp) {
                start++;
            }
            num[end] = num[start];
        }
        num[start] = tmp;
        return start;
    }
}
