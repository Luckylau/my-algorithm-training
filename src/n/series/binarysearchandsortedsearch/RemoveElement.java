package n.series.binarysearchandsortedsearch;

import java.util.Arrays;

/**
 * @Author luckylau
 * @Date 2022/3/30
 * Given an array and a value, remove all occurrences of that value in place and return the new length.
 * The order of elements can be changed, and the elements after the new length don't matter.
 * Example
 * Given an array [0,4,4,0,0,2,4,4], value=4
 * return 4 and front four elements of the array is [0,2,0,0]
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 4, 4, 0, 0, 2, 4, 4};
        System.out.println(Arrays.toString(nums));
        RemoveElement removeElement = new RemoveElement();
        System.out.println(Arrays.toString(removeElement.removeElement(nums, 4)));

    }

    public int[] removeElement(int[] A, int elem) {
        int i = 0;
        int pointer = A.length - 1;
        while (i <= pointer) {
            if (A[i] == elem) {
                A[i] = A[pointer];
                pointer--;
            } else {
                i++;
            }
        }
        return Arrays.copyOf(A, pointer + 1);
    }


}
