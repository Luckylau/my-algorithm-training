/**
 * Given an array and a value, remove all occurrences of that value in place and return the new length.
 * The order of elements can be changed, and the elements after the new length don't matter.
 * Example
 * Given an array [0,4,4,0,0,2,4,4], value=4
 * return 4 and front four elements of the array is [0,2,0,0]
 */
package chapter2;

import java.util.Arrays;

public class RemoveElement {

	public int removeElement(int[] A, int elem) {
		// write your code here
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
		return pointer + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 0, 4, 4, 0, 0, 2, 4, 4 };
		System.out.println(Arrays.toString(nums));
		System.out.println("the length of old array is " + nums.length);
		RemoveElement removeElement = new RemoveElement();
		int len = removeElement.removeElement(nums, 4);
		System.out.println("the length of new array is " + len);
		System.out.println(Arrays.toString(nums));
		nums = Arrays.copyOf(nums, len);
		System.out.println(Arrays.toString(nums));

	}

}
