package m.series.str;

/**
 * 数组中的第K个最大元素
 *
 * @Author luckylau
 * @Date 2021/4/13
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int partition = partition(nums, start, end);
        while (partition != k - 1 && start < end) {
            if (partition > k - 1) {
                end = partition - 1;
            } else {
                start = partition + 1;
            }
            partition = partition(nums, start, end);
        }
        return nums[partition];


    }

    private int partition(int[] nums, int start, int end) {
        int tmp = nums[start];
        while (start < end) {
            while (start < end && nums[end] <= tmp) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] >= tmp) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = tmp;
        return start;
    }
}
