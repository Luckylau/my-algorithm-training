package n.series.binarysearchandsortedsearch;

import java.util.Arrays;

/**
 * @Author luckylau
 * @Date 2022/3/30
 * Merge two given sorted integer array A and B into a new sorted integer array.
 * Example
 * A=[1,2,3,4]
 * B=[2,4,5,6]
 * return [1,2,2,3,4,4,5,6]
 */
public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 5, 7, 8};
        System.out.println(Arrays.toString(A));
        int[] B = new int[]{2, 4, 6, 9, 10};
        System.out.println(Arrays.toString(B));
        MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
        System.out.println(Arrays.toString(mergeTwoSortedArrays.mergeSortedArray(A, B)));

    }

    public int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null || A.length == 0) {
            return B;
        }
        if (B == null || B.length == 0) {
            return A;
        }
        int[] result = new int[A.length + B.length];
        int m = A.length - 1;
        int n = B.length - 1;
        int index = m + n + 1;

        while (m >= 0 && n >= 0) {
            if (A[m] >= B[n]) {
                result[index--] = A[m--];
            } else {
                result[index--] = B[n--];
            }
        }

        while (m >= 0) {
            result[index--] = A[m--];
        }

        while (n >= 0) {
            result[index--] = B[n--];
        }

        return result;
    }

}
