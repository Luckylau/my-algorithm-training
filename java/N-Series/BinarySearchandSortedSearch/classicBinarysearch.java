/**
 * Classical Binary Search
 *
 * Given an sorted integer array - nums, and an integer - target. Find the first position of
 * target in nums, return -1 if target doesn¡¯t exist.
 *
 */
package chapter2;

public class classicBinarysearch {
	
	public int binarySearch(int [] nums , int target){
		
		if(nums.length==0){
			return -1;
		}
		int start=0;
		int end=nums.length-1;
		
		while(start+1<end){
			int mid=start+(end-start)/2;
			if(nums[mid]==target){
				return mid;
			}else if (nums[mid]>target){
				end=mid;
			}else{
				start=mid;
			}
		}
		
		if(nums[start]==target || nums[end]==target){
			return nums[start]==target ? start: end;
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		int[] nums={1, 2, 2, 3, 8, 10,12};
		classicBinarysearch classicBinarysearch = new classicBinarysearch();
		System.out.println(" the first position of target is "+classicBinarysearch.binarySearch(nums, 2));
		
	}
}
 