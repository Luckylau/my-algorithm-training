package n.series.binarysearchandsortedsearch;

import java.util.Arrays;

/**
 * @Author luckylau
 * @Date 2022/3/30
 * Search for a Range
 * Given a sorted array of n integers, find the starting and ending position of a given target value.
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchForRange {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 4, 4};
        SearchForRange searchForRange = new SearchForRange();
        System.out.println(Arrays.toString(searchForRange.searchRange(nums, 2)));
    }

    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) {
            return new int[]{-1, -1};
        }
        int start = 0;
        int end = A.length - 1;
        int[] bound = new int[2];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] == target) {
            bound[0] = start;
        } else if (A[end] == target) {
            bound[0] = end;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }

        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            bound[1] = end;
        } else if (A[start] == target) {
            bound[1] = start;
        } else {
            bound[0] = bound[1] = -1;
        }
        return bound;
    }

}