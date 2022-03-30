package n.series.binarysearchandsortedsearch;

import java.util.Arrays;

/**
 * @Author luckylau
 * @Date 2022/3/30
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Notice
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 * Example
 * A = [1, 2, 3, empty, empty], B = [4, 5]
 * After merge, A will be filled as [1, 2, 3, 4, 5]
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] A = new int[]{9, 10, 11, 12, 13, 0, 0, 0, 0};
        int[] B = new int[]{4, 5, 6, 7};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.mergeSortedArray(A, 5, B, 4);
        System.out.println(Arrays.toString(A));
    }

    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int index = m + n;
        while (m > 0 && n > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[--index] = A[--m];
            } else {
                A[--index] = B[--n];
            }
        }
        while (n > 0) {
            A[--index] = B[--n];
        }
    }

}
