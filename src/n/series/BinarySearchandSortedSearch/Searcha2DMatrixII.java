package n.series.BinarySearchandSortedSearch;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.
 * <p>
 * This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * Integers in each column are sorted from up to bottom.
 * No duplicate integers in each row or column.
 */
public class Searcha2DMatrixII {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        Searcha2DMatrixII searcha2DMatrixII = new Searcha2DMatrixII();
        System.out.println(searcha2DMatrixII.find(nums, 7));
    }

    private boolean find(int[][] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums[0] == null || nums[0].length == 0) {
            return false;
        }
        int len = nums.length - 1;
        int i = 0;
        while (len >= 0 && i < nums[0].length) {
            if (nums[len][i] > target) {
                len--;
            } else if (nums[len][i] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }


}
