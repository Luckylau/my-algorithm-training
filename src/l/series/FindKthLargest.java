package l.series;

/**
 * @Author luckylau
 * @Date 2020/1/6
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(nums, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int pivot = partition(nums, start, end);
        while (pivot != k - 1 && start < end) {
            if (pivot > k - 1) {
                end = pivot - 1;
                pivot = partition(nums, start, end);
            } else if (pivot < k - 1) {
                start = pivot + 1;
                pivot = partition(nums, start, end);
            }
        }
        return nums[pivot];

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
