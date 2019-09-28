/**
 * Classical Binary Search
 * <p>
 * Given an sorted integer array - nums, and an integer - target. Find the first position of
 * target in nums, return -1 if target does not exist.
 */
package n.series.BinarySearchandSortedSearch;

public class ClassicBinarysearch {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        ClassicBinarysearch classicBinarysearch = new ClassicBinarysearch();
        System.out.println(" the first position of target is " + classicBinarysearch.binarySearch(nums, 3));
        System.out.println(" the first position of target is " + classicBinarysearch.binarySearch2(nums, 3));

    }

    private int binarySearch(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] == target || nums[end] == target) {
            return nums[start] == target ? start : end;
        }

        return -1;
    }

    private int binarySearch2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
 