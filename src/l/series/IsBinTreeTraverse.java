package l.series;

/**
 * 判断整数序列是不是二元查找树的后序遍历结果
 * 判断整数序列是不是二元查找树的前序遍历结果
 */
public class IsBinTreeTraverse {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 6, 9, 11, 10, 8};
        int[] nums2 = new int[]{8, 6, 5, 7, 10, 9, 11};
        IsBinTreeTraverse isBinTreeTraverse = new IsBinTreeTraverse();
        System.out.println(isBinTreeTraverse.isBinTreePostTraverse(nums));
        System.out.println(isBinTreeTraverse.isBinTreePreTraverse(nums2));

    }

    /**
     * 后序遍历
     *
     * @param nums
     * @return
     */
    public boolean isBinTreePostTraverse(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private boolean helper(int[] nums, int start, int end) {
        if (start >= end) {
            return true;
        }
        boolean flag = false;
        int pivot = 0;
        for (int i = start; i < end; i++) {
            if (!flag && nums[i] > nums[end]) {
                pivot = i;
                flag = true;
            } else if (flag && nums[i] < nums[end]) {
                return false;
            }
        }

        return helper(nums, start, pivot - 1) && helper(nums, pivot, end - 1);
    }

    /**
     * 前序遍历
     * @param nums
     * @return
     */
    public boolean isBinTreePreTraverse(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        return helper2(nums, 0, nums.length - 1);
    }

    private boolean helper2(int[] nums, int start, int end) {
        if (start >= end) {
            return true;
        }
        int pivot = 0;
        boolean flag = false;
        for (int i = end; i > start; i--) {
            if (!flag && nums[i] < nums[start]) {
                pivot = i;
                flag = true;
            } else if (flag && nums[i] > nums[start]) {
                return false;
            }
        }
        return helper2(nums, start + 1, pivot) && helper2(nums, pivot + 1, end);
    }

}
