package o.series;

import java.util.Arrays;

/**
 * @Author luckylau
 * @Date 2019/12/19
 */
public class SearchRange {
    public static int[] searchRange3(int[] A, int target) {
        int[] res = new int[]{-1, -1};
        if (A == null || A.length == 0) {
            return res;
        }
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid - 1;
            } else if (A[mid] < target) {
                start = mid + 1;
            } else {
                if (mid - 1 < 0 || (mid - 1 >= 0 && A[mid - 1] < A[mid])) {
                    res[0] = mid;
                    break;
                } else {
                    end = mid - 1;
                }
            }
        }
        if (res[0] == -1) {
            return res;
        }

        start = 0;
        end = A.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid - 1;
            } else if (A[mid] < target) {
                start = mid + 1;
            } else {
                if (mid + 1 > A.length - 1 || (mid + 1 <= A.length - 1 && A[mid + 1] > A[mid])) {
                    res[1] = mid;
                    break;
                } else {
                    start = mid + 1;
                }
            }
        }

        if (res[1] == -1) {
            res[1] = res[0];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 2};
        SearchRange searchRange = new SearchRange();
        System.out.println(Arrays.toString(searchRange.searchRange(a, 2)));
    }

    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (A[start] != target) {
            res[0] = res[1] = -1;
            return res;
        }
        res[0] = start;

        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[end] == target) {
            res[1] = end;
        } else {
            res[1] = start;
        }

        return res;
    }

    public int[] searchRange2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] ret = new int[2];
        int start = 0;
        int end = nums.length - 1;

        // 找到第一个target
        /// start 左侧的都比target小
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // check nums[start];
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        // find first value
        ret[0] = start;

        // start = start
        end = nums.length - 1;
        // 找到最后一个target
        // end 右侧的都比target 大
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        ret[1] = end;
        return ret;

    }
}
