package l.series;

/**
 * 查找移位有序数组的最小值，例如:
 * [4, 5, 6, 7, 8, 9, 10, 1, 2, 3]
 * 结果为1
 */
public class FindShiftArrayMin {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 1};
        FindShiftArrayMin findShiftArrayMin = new FindShiftArrayMin();
        System.out.println(findShiftArrayMin.findShiftArrayMin(nums));

    }

    public int findShiftArrayMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;
        if (nums[end] > nums[mid]) {
            return helper(nums, start, mid);
        } else {
            return helper(nums, mid + 1, end);
        }
    }

}
