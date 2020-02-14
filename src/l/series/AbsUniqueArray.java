package l.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 有一个已经排序的数组（升序），数组中可能有正数、负数或0,可重复，求数组中绝对值不重复的元素
 *
 * @Author luckylau
 * @Date 2020/2/13
 */
public class AbsUniqueArray {
    public static void main(String[] args) {
        int[] nums = {-3, -2, -1, 1, 2, 5};
        AbsUniqueArray absUniqueArray = new AbsUniqueArray();
        System.out.println(Arrays.toString(absUniqueArray.absUniqueArrayV2(nums).toArray()));
        System.out.println(Arrays.toString(absUniqueArray.absUniqueArray(nums).toArray()));
    }

    public List<Integer> absUniqueArrayV2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int start = 0;
        int end = nums.length - 1;
        int curNum;
        List<Integer> repeated = new ArrayList<>();
        if (Math.abs(nums[start]) > Math.abs(nums[end])) {
            curNum = Math.abs(nums[start]);
            start++;
        } else {
            curNum = Math.abs(nums[end]);
            end--;
        }

        while (start <= end) {
            if (Math.abs(nums[end]) > Math.abs(nums[start])) {
                if (Math.abs(nums[end]) == curNum) {
                    if (!repeated.contains(curNum)) {
                        repeated.add(curNum);
                    }
                }
                curNum = Math.abs(nums[end]);
                end--;
            } else {
                if (Math.abs(nums[start]) == curNum) {
                    if (!repeated.contains(curNum)) {
                        repeated.add(curNum);
                    }
                }
                curNum = Math.abs(nums[start]);
                start++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (!repeated.contains(Math.abs(nums[i]))) {
                res.add(Math.abs(nums[i]));
            }
        }

        return res;

    }

    public List<Integer> absUniqueArray(int[] arr) {
        List<Integer> ret = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return ret;
        }
        if (arr.length == 1) {
            ret.add(arr[0]);
            return ret;
        }

        int len = arr.length;
        int lo = 0;
        int hi = len - 1;
        while (lo <= hi) {
            if (arr[lo] >= 0 || arr[hi] <= 0) {
                oneSide(arr, lo, hi, ret);
                return ret;
            } else {
                int lo1 = Math.abs(arr[lo]);
                int hi1 = Math.abs(arr[hi]);
                if (lo1 < hi1) {
                    // move hi1
                    int cur = arr[hi];
                    int j = hi;
                    while (j - 1 >= lo && arr[j - 1] == cur) {
                        j--;
                    }
                    if (j == hi) {
                        ret.add(Math.abs(arr[j]));
                    }
                    hi = j - 1;
                } else if (lo1 > hi1) {
                    int cur = arr[lo];
                    int j = lo;
                    while (j + 1 <= hi && arr[j + 1] == cur) {
                        j++;
                    }
                    if (j == lo) {
                        ret.add(Math.abs(arr[j]));
                    }
                    lo = j + 1;
                } else { // the same
                    // move lo and move hi
                    int cur = arr[hi];
                    int j = hi;
                    while (j - 1 >= lo && arr[j - 1] == cur) {
                        j--;
                    }
                    hi = j - 1;

                    cur = arr[lo];
                    j = lo;
                    while (j + 1 <= hi && arr[j + 1] == cur) {
                        j++;
                    }
                    lo = j + 1;

                }
            }
        }
        return ret;
    }

    public void oneSide(int[] arr, int start, int end, List<Integer> ret) {
        for (int i = start; i <= end; i++) {
            int cur = arr[i];
            int j = i;
            while (j + 1 <= end && arr[j + 1] == cur) {
                j++;
            }
            if (j == i) {
                ret.add(Math.abs(arr[i]));
            } else {
                i = j;
            }
        }
    }

}
