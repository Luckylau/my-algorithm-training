/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3]
 */

package n.series.BinarySearchandSortedSearch;

public class RemovDuplicatesfromSortedArray2 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        RemovDuplicatesfromSortedArray2 removDuplicatesfromSortedArray2 = new RemovDuplicatesfromSortedArray2();
        System.out.println(removDuplicatesfromSortedArray2.removeDuplicates(nums));
        int[] nums2 = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(removDuplicatesfromSortedArray2.removeDuplicates2(nums2));
    }

    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            } else {
                if (j == 0 && i > j && nums[j] == nums[i]) {
                    nums[++j] = nums[i];
                }
                if (j >= 1 && nums[i] != nums[j - 1]) {
                    nums[++j] = nums[i];
                }
            }
        }
        return j + 1;
    }

    public int removeDuplicates2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return 0;
        int startPosition = 0;
        boolean isRepeated = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[startPosition]) {
                isRepeated = false;
                startPosition++;
                nums[startPosition] = nums[i];
            } else {
                if (isRepeated == false) {
                    startPosition++;
                    nums[startPosition] = nums[i];
                    isRepeated = true;
                }
            }
        }
        return startPosition + 1;
    }
}
