/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * Example
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * 
 */
package chapter2;


public class RemovDuplicatesfromSortedArray {
	
	 public int removeDuplicates(int[] nums) {
	        // write your code here
	        if ( nums.length == 0 ){
	            return 0;
	        }
	        int j = 0;
	        for(int i =0 ;i < nums.length; i++ ) {
	            if (nums[i] != nums[j]) {
	                j++;
	                nums[j] = nums[i];
	            }
	        }
	        return j + 1;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = new int [] {1,1,2,4,4,5,5,5,8,9,12,15,16};
		RemovDuplicatesfromSortedArray removDuplicatesfromSortedArray = new RemovDuplicatesfromSortedArray();
		System.out.println("the length is " + removDuplicatesfromSortedArray.removeDuplicates(nums));

	}

}
