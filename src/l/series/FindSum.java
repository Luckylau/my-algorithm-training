package l.series;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 从数组中查找出和为某一值的一组数据即可。
 */
public class FindSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 5, 2, 1, 6, 10, 7};
        FindSum findSum = new FindSum();
        System.out.println(Arrays.toString(findSum.findSum(nums, 8)));
        int[] nums2 = new int[]{2, 4, 5, 2, 1, 6, 10, 7};
        System.out.println(Arrays.toString(findSum.findSum2(nums2, 8)));
        int[] nums3 = new int[]{2, 4, 5, 2, 1, 6, 10, 7};
        System.out.println(Arrays.toString(findSum.findSum3(nums3, 8)));
        int[] nums4 = new int[]{2, 4, 5, 2, 1, 6, 10, 7};
        System.out.println(Arrays.toString(findSum.findSum4(nums4, 8)));

    }

    /**
     * 求和，暴力破解
     */
    public int[] findSum(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[j] == target - nums[i]) {
                    res[0] = nums[i];
                    res[1] = nums[j];
                    return res;
                }
            }
        }
        return res;
    }

    /**
     * 排序后二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] findSum2(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        quickSort(nums);
        for (int i = 0; i < nums.length; i++) {
            int tmp = binarySearch(nums, target - nums[i]);
            if (tmp != -1) {
                res[0] = nums[i];
                res[1] = nums[tmp];
                return res;
            }
        }
        return res;
    }

    private int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }
        return -1;
    }

    private void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        helper(nums, 0, nums.length - 1);
    }

    private void helper(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = partition(nums, low, high);
            helper(nums, low, pivot - 1);
            helper(nums, pivot + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int tmp = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= tmp) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= tmp) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = tmp;
        return low;
    }

    /**
     * 排序后双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] findSum3(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        quickSort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                res[0] = nums[start];
                res[1] = nums[end];
                return res;
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else if (nums[start] + nums[end] > target) {
                end--;
            }
        }
        return res;
    }

    /**
     * hash，效果最好
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] findSum4(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashmap.containsKey(target - nums[i])) {
                hashmap.put(nums[i], i);
            } else {
                res[0] = nums[i];
                res[1] = nums[hashmap.get(target - nums[i])];
                return res;
            }

        }
        return res;
    }

}
