/**
 *  @Author luckylau
 *  @Date 2022/3/30
 * 查找峰值
 * There is an integer array which has the following features:
 * The numbers in adjacent positions are different.
 * A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 * We define a position P is a peek if:
 * A[P] > A[P-1] && A[P] > A[P+1]
 * Example
 * Given [1, 2, 1, 3, 4, 5, 7, 6]
 * Return index 1 (which is number 2) or 6 (which is number 7)
 * Time complexity O(logN)
 */
package n.series.binarysearchandsortedsearch;

public class FindPeak {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 4, 5, 6, 7, 9, 8, 10, 12, 11};
        FindPeak findPeak = new FindPeak();
        System.out.println(findPeak.findPeak(nums));

    }

    public int findPeak(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            }
            if (A[mid] > A[start] && A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start + 1] < A[start] && A[start] > A[start - 1]) {
            return start;
        } else {
            return end;
        }
    }

}
