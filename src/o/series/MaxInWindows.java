package o.series;
/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author luckylau
 * @Date 2019/12/26
 */
public class MaxInWindows {
    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        MaxInWindows maxInWindows = new MaxInWindows();
        System.out.println(maxInWindows.maxInWindows(num, 3));

    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length == 0) {
            return list;
        }
        if (size == 0 || size > num.length) {
            return list;
        }

        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!dq.isEmpty() && num[i] > num[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);

            if (i > dq.peekFirst() + size - 1) {
                dq.pollFirst();
            }

            if (i >= size - 1) {
                list.add(num[dq.peekFirst()]);
            }
        }
        return list;
    }
}
