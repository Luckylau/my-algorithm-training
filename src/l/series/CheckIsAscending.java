package l.series;

/**
 * 递归判断是否是升序排列
 */
public class CheckIsAscending {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        CheckIsAscending CheckIsAscending = new CheckIsAscending();
        System.out.println(CheckIsAscending.checkIsAscending(nums));
    }

    public boolean checkIsAscending(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        return helper(nums, nums.length - 1);
    }

    private boolean helper(int[] nums, int end) {
        if (end == 0) {
            return true;
        }
        if (nums[end] < nums[end - 1]) {
            return false;
        }
        return helper(nums, end - 1);
    }

}
